package accounting;

import java.sql.*;

public class DataAccessor implements AutoCloseable {
    private String url;
    private Connection conn;

    public DataAccessor(String url) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.url = url;
        this.conn = null;
    }

    private Connection connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url);
        }
        return conn;
    }

    @Override
    public void close() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public void fillTestData() throws SQLException {
        try (var statement = connect().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                    "                                     login TEXT UNIQUE NOT NULL,\n" +
                    "                                     password TEXT NOT NULL,\n" +
                    "                                     role TEXT NOT NULL,\n" +
                    "                                     PRIMARY KEY(login));");
            statement.execute("INSERT OR IGNORE INTO users VALUES ('Katya', '12345', 'admin');");
            statement.execute("INSERT OR IGNORE INTO users VALUES ('Fedya', '11111', 'admin');");
            statement.execute("INSERT OR IGNORE INTO users VALUES ('Sasha', '11111', 'admin');");
            statement.execute("INSERT OR IGNORE INTO users VALUES ('User', '11111', 'accountant');");
        }
    }

    public boolean authentificateUser(User user, UserCredentials credentials) throws SQLException, DataException {
        try (var statement = connect().prepareStatement("SELECT * FROM users WHERE login is (?)")) {
            statement.setString(1, credentials.getLogin());
            try (var results = statement.executeQuery()) {
                while (results.next()) {
                    String password = results.getString("password");
                    if (password.equals(credentials.getPassword())) {
                        String role = results.getString("role");
                        user.setLogin(credentials.getLogin());
                        try {
                            user.setRole(Role.valueOf(role.toUpperCase()));
                        } catch (IllegalArgumentException exc) {
                            throw new DataException("Invalid role: " + role);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }
}