package accounting;

import accounting.gui.LoginForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try (var accessor = new DataAccessor("jdbc:sqlite:database.sqlite")) {
            var controller = new LoginController(accessor);
            var form = new LoginForm(controller);
            form.show();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Fatal error", JOptionPane.ERROR_MESSAGE);
        }
    }
}