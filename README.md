### Эксперимент по развертыванию RabbitMQ в Docker с использованием Spring Boot

#### Полезные ресурсы:
1. [Как запускать RabbitMQ в Docker](https://habr.com/ru/companies/slurm/articles/704208/)
2. [Docker HUB: RabbitMQ](https://hub.docker.com/_/rabbitmq)
3. [RabbitMQ + Spring Boot + Docker: Отправляем и получаем сообщения через Producer и Consumer. Пошаговое руководство](https://habr.com/ru/articles/703352/)
4. [RabbitMQ: установка и управление брокером сообщений](https://ploshadka.net/rabbitmq-ustanovka-i-upravleniem-brokerom-soobshhenijj/)

### Запуск RabbitMQ в Docker:

1. Клонируйте репозиторий, содержащий файлы Docker Compose:
   ```bash
   git clone git clone https://github.com/ilyakineev/RabbitMQ.git
   cd RabbitMQ
   ```

2. Запустите контейнер RabbitMQ с использованием Docker Compose:
   ```bash
   cd docker
   docker-compose up -d
   ```

3. Проверьте, что контейнер запущен:
   ```bash
   docker ps
   ```

4. Перейдите по адресу [RabbitMQ Management](http://localhost:15672/) и войдите с учетными данными по умолчанию (user/password).

5. Остановите контейнер RabbitMQ при завершении работы:
   ```bash
   docker-compose down
   ```

### Запуск Spring Boot Consumer и Producer:

1. Запустите Consumer:
   ```bash
   ./gradlew :Consumer:bootRun
   ```

2. Запустите Producer:
   ```bash
   ./gradlew :Producer:bootRun
   ```

### Дополнительные действия:

- Проверьте состояние приложения:
   ```bash
   curl http://localhost:8086/health
   ```

- Отправьте тестовое сообщение с помощью curl:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"message": "Тестовое сообщение!!!", "routingKey": "myRoutingKey"}' http://localhost:8086/send
   ```

### Возможные проблемы и дополнительные команды:

- Проверка открытых портов:
   ```bash
   sudo lsof -i -P -n | grep LISTEN
   ```

- Подключение к консоли контейнера:
   ```bash
   docker exec -it rabbitmq /bin/bash
   ```

- Показ пользователей RabbitMQ:
   ```bash
   rabbitmqctl list_users
   ```

- Создание нового virtualhost:
   ```bash
   rabbitmqctl add_vhost /cpp
   ```

- Просмотр доступных виртуальных хостов:
   ```bash
   rabbitmqctl list_vhosts
   ```