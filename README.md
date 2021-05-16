# Accounting-tp-project

 + Для работы с проектом необходимо подключить дополнительные либы из папки `lib`:
```
    sqlite-jdbc-3.34.0.jar (для работы с бд)
    junit-4.12.jar (для тестирования)
    hamcrest-core-1.3.jar(-//-)
```

+ Код, на основе которого создаётся БД.
```
  CREATE TABLE IF NOT EXISTS users (
                                     login TEXT UNIQUE NOT NULL,
                                     password TEXT NOT NULL,
                                     role TEXT NOT NULL,
                                     PRIMARY KEY(login));

INSERT INTO users VALUES ('Katya', '11111', 'admin');
INSERT INTO users VALUES ('Fedya', '11111', 'admin');
INSERT INTO users VALUES ('Sasha', '11111', 'admin');
INSERT INTO users VALUES ('User', '11111', 'user');

UPDATE users SET password = '12345' WHERE login = 'Katya';

SELECT  * FROM users;
```

+ Диаграмма классов (чтобы было нагляднее)


![diagram](https://github.com/Kat-ies/Accounting-tp-project/blob/backend/diagram.png)
