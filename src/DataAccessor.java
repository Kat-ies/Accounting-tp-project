import java.sql.SQLException;

public class DataAccessor {
    public String doesUserExists(User user) throws SQLException, ClassNotFoundException {
        String result = "";

        DbHandler handler = new DbHandler();
        handler.connect();
        handler.createDB();
        handler.writeDB();
        //handler.showDB();
        handler.changeDB();
        result = handler.searchInDB(user.getLogin(), user.getPassword());
        handler.closeDB();
        return result;
    }
}
