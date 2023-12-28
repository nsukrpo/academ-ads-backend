# academ-ads-backend
## Возможны 2 варианта запуска
## 1
Требует наличия docker

При использовании OS Windows необходимо убедиться, 
что в файле mvnw разделителем строки является символ LF, а не CRLF


Запускаем в папке с проектом команду

```docker-compose up```

## 2
1. Установить себе PostgreSQL 16
2. Создать роль (если ее не будет): CREATE ROLE POSTGRES SUPERUSER LOGIN
3. Создать БД: CREATE DATABASE mydb
4. Запустить настроенную БД
5. mvn package
6. java -jar target/<jar файл после сборки>




Если Вы хотите запустить с использованием авторизации, то нужно в файле backend/src/main/java/nsukrpo/backend/services/impls/SecurityServiceImpl.java
заменить значение переменной testRegime на false.
