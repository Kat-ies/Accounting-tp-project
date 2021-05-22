# Accounting-tp-project

Маленькие заметки на полях :)

 + Я залила весь проект со всеми необходимыми либами. Их три, и если у вас что-то не работает, проверьте, чтобы у вас из папки `lib` было подключено:
```
    sqlite-jdbc-3.34.0.jar (для работы с бд)
    junit-4.12.jar (для тестирования)
    hamcrest-core-1.3.jar(-//-)
```

+ Также я оставлю код, на основе которого создаётся БД. Он вам вроде не должен понадобиться, но пусть эти команды тоже тут будут.
```
  CREATE TABLE IF NOT EXISTS users (
                                     login TEXT UNIQUE NOT NULL,
                                     password TEXT NOT NULL,
                                     role TEXT NOT NULL,
                                     PRIMARY KEY(login));

INSERT INTO users VALUES ('Katya', '11111', 'admin');
INSERT INTO users VALUES ('Fedya', '11111', 'admin');
INSERT INTO users VALUES ('Sasha', '11111', 'admin');
INSERT INTO users VALUES ('User', '11111', 'accountant');

UPDATE users SET password = '12345' WHERE login = 'Katya';

SELECT  * FROM users;
```

+ Диаграмма классов (чтобы бьыло нагляднее)


![diagram](https://github.com/Kat-ies/Accounting-tp-project/blob/backend/diagram.png)
