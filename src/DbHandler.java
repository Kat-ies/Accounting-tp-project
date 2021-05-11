import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbHandler {
    public static Connection conn;
    public static Statement statement;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void connect() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:database.sqlite");
        //System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void createDB() throws ClassNotFoundException, SQLException {
        statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                "                                     login TEXT UNIQUE NOT NULL,\n" +
                "                                     password TEXT NOT NULL,\n" +
                "                                     role TEXT NOT NULL,\n" +
                "                                     PRIMARY KEY(login));");

        //System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void writeDB() throws SQLException {
        statement.execute("INSERT  OR IGNORE INTO users VALUES ('Katya', '11111', 'admin');");
        statement.execute("INSERT  OR IGNORE INTO users VALUES ('Fedya', '11111', 'admin');");
        statement.execute("INSERT  OR IGNORE INTO users VALUES ('Sasha', '11111', 'admin');");
        statement.execute("INSERT  OR IGNORE INTO users VALUES ('User', '11111', 'user');");

        //System.out.println("Таблица заполнена");
    }

    // --------Изменение таблицы--------
    public static void changeDB() throws SQLException {
        statement.execute("UPDATE users SET password = '12345' WHERE login = 'Katya';");
        //System.out.println("Таблица изменена");
    }

    // -------- Поиск по таблице--------
    public static String searchInDB(String login, String password) throws ClassNotFoundException {
        try {
            resSet = statement.executeQuery("SELECT * FROM users WHERE password is " + password);

            //Вообще здесь можно сделать один красивый запрос в бд, но java почему-то кидает ошибку,
            //хотя сам sql на запрос отвечает.
            while (resSet.next()) {
                String databaseLogin = resSet.getString("login");
                String role = resSet.getString("role");
                if (databaseLogin.equals(login)) {
                    return role;
                }
            }

            return "error";
        } catch (SQLException ex) {
            return "error";
        }
    }

    // -------- Вывод таблицы--------
    public static void showDB() throws ClassNotFoundException, SQLException {
        resSet = statement.executeQuery("SELECT * FROM users");

        while (resSet.next()) {
            System.out.println("id = " + resSet.getInt("id"));
            System.out.println("login = " + resSet.getString("login"));
            System.out.println("password = " + resSet.getString("password"));
            System.out.println("role = " + resSet.getString("role"));
            System.out.println();
        }

    }

    // --------Закрытие--------
    public static void closeDB() throws ClassNotFoundException, SQLException {
        if (!conn.isClosed()) {
            conn.close();
        }
        if (!statement.isClosed()) {
            statement.close();
        }
        if (resSet != null && !resSet.isClosed()) {
            resSet.close();
        }
        //System.out.println("Соединения закрыты");
    }

}