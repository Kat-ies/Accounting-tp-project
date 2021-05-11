import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        LoginController controller = new LoginController();

        Scanner input = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = input.next();
        System.out.println("Введите пароль: ");
        String password = input.next();

        try {
            controller.login(login, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}