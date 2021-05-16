import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        LoginController controller = new LoginController();
        GuiLoginForm form = new GuiLoginForm(controller);
        form.show();
    }
}