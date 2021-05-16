import javax.swing.*;
import java.awt.*;

public class GuiLoginForm implements LoginForm {
    private JFrame frame;
    private JTextField loginField;
    private JPasswordField passwordField;
    private LoginController controller;

    GuiLoginForm(LoginController controller) {
        this.controller = controller;
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JPanel entryPanel = new JPanel(new SpringLayout());
        entryPanel.setLayout(new GridBagLayout());
        entryPanel.add(new JLabel("Login:"),
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.5, GridBagConstraints.EAST,
                        0, new Insets(5, 5, 5, 5), 0, 0));
        loginField = new JTextField();
        entryPanel.add(loginField,
                new GridBagConstraints(1, 0, 1, 1, 1.0, 0.5, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        entryPanel.add(new JLabel("Password:"),
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.5, GridBagConstraints.EAST,
                        0, new Insets(0, 0, 0, 0), 0, 0));
        passwordField = new JPasswordField();
        entryPanel.add(passwordField,
                new GridBagConstraints(1, 1, 1, 1, 1.0, 0.5, GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        frame.add(entryPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(comp -> login());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(comp -> cancel());
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setTitle("Login");
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(400, 150));
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

    public void cancel() {
        JOptionPane.showMessageDialog(frame, "Login cancelled.", "Login", JOptionPane.INFORMATION_MESSAGE);
        close();
    }

    @Override
    public void show() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void login() {
        String role;
        try {
            role = controller.login(loginField.getText(), String.copyValueOf(passwordField.getPassword()));
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(frame, "Error: " + exc.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (role.equals("error")) {
            JOptionPane.showMessageDialog(frame, "Invalid login or password", "Login", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(frame,
                "Successfully logged in as " + loginField.getText() + " with role " + role,
                "Login", JOptionPane.INFORMATION_MESSAGE);
        close();
    }
}
