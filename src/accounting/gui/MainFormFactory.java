package accounting.gui;

import accounting.IMainForm;
import accounting.User;

public class MainFormFactory {
    public static IMainForm create(User user) {
        switch (user.getRole()) {
            case ADMIN:
                return new AdminMainForm(user);
            case ACCOUNTANT:
                return new AccountantMainForm(user);
        }
        throw new IllegalArgumentException("Unknown user role");
    }
}
