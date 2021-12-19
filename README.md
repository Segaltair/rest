Для запуска проекта необходимо:
1. `docker-compose up -d` - создание контейнера `rest_db`, содержащего пустую БД.
2. `mvn clean install`
3. `java -jar target/rest.jar`