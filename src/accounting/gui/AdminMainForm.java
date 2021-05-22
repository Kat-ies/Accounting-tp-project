package accounting.gui;

import accounting.IMainForm;
import accounting.User;

import javax.swing.*;
import java.awt.*;

public class AdminMainForm implements IMainForm {
    private JFrame frame;

    public AdminMainForm(User user) {
        frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JLabel("Welcome, " + user.getLogin() + "!", SwingConstants.CENTER));
        frame.add(new JButton("Generate reports"));
        frame.add(new JButton("Add worker"));
        frame.add(new JButton("Delete worker"));
        frame.add(new JButton("Update worker"));
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
