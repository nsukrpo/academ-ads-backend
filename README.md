# academ-ads-backend
## Установка
1. Установить себе PostgreSQL 16
2. Создать роль (если ее не будет): CREATE ROLE POSTGRES SUPERUSER LOGIN
3. Создать БД: CREATE DATABASE mydb
## Запуск
Через Maven:
1. Запустить настроенную БД
2. mvn package
3. java -jar target/<jar файл после сборки>
