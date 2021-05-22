package accounting.gui;

import accounting.IMainForm;
import accounting.User;

import javax.swing.*;
import java.awt.*;

public class AccountantMainForm implements IMainForm {
    private JFrame frame;

    public AccountantMainForm(User user) {
        frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JLabel("Welcome, " + user.getLogin() + "!", SwingConstants.CENTER));
        frame.add(new JButton("Input data from time attendance card"));
        frame.add(new JButton("Edit time attendance cards"));
        frame.add(new JButton("Change worker payment method"));
        frame.add(new JButton("Generate reports"));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Main window");
    }

    @Override
    public void show() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
