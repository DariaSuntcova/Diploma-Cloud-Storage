# «Облачное хранилище»
## Описание проекта
Задача — разработать REST-сервис. Сервис должен предоставить REST-интерфейс для загрузки файлов и вывода списка уже загруженных файлов пользователя.

Все запросы к сервису должны быть авторизованы. Заранее подготовленное веб-приложение (FRONT) должно подключаться к разработанному сервису без доработок, а также использовать функционал FRONT для авторизации, загрузки и вывода списка файлов пользователя.

## Требования к приложению
- Сервис должен предоставлять REST-интерфейс для интеграции с FRONT.
- Сервис должен реализовывать все методы, описанные в [yaml-файле](https://github.com/netology-code/jd-homeworks/blob/master/diploma/CloudServiceSpecification.yaml):
1. Вывод списка файлов.
2. Добавление файла.
3. Удаление файла.
4. Авторизация.
- Все настройки должны вычитываться из файла настроек (yml).
- Информация о пользователях сервиса (логины для авторизации) и данные должны храниться в базе данных (на выбор студента).
## Реализация
- Приложение разработано с использованием Spring Boot 3.
- Использован сборщик пакетов maven.
- Для запуска используется docker-compose.
- Реализована аутентификация с использованием JSON Web Tokens (JWT).
- Добавлен CORS-фильтр.
- Данные пользователей и пути к файлам хранятся в базе данных(Postgres).
- Реализовано создание таблиц и добавление тестовых пользователей в базу данных по средствам Flyway Migration.
- Для хранения файлов используется локальная файловая система
- Код покрыт тестами с использованием mockito.

## Запуск приложения
Для запуска приложения
- Загрузить проект на свой компьютер.
- Перейти в папку проекта, где лежит файл docker-compose.yml.
- Вызвать командную строку из этой папки (в адресной строке проводника написать cmd и нажать enter)
- Написать команду docker-compose up -d

Backend запускается на порту 8090.

Postgres запускается на порту 5432.

Для интеграции фронт должен быть запущен на порту 8080

## Тестовые пользователи
1. login : user, password : user
2. login : admin, password : admin
