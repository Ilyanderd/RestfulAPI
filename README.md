Приложение по созданию, получению, удалению и изменению книг. Сохранение книг реализовано через базу данных MySQL. Подключен брокер сообщений RabbitMQ, который отправляет сообщения в очередь при добавлении, изменении и удалении книг(и). Слушатель на стороне приложения считывает сообщения и применяет соответствующие методы.
