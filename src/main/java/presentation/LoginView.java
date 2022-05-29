package presentation;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private final JLabel userLabel;
    private final JLabel passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private  final JButton loginButton;


    /**
     * Constructor for the main View
     */
    public LoginView(){
        this.setSize(300,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Log In");
        this.setBackground(Color.white);
        getContentPane().setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 50, 90, 25);
        userLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        getContentPane().add(userLabel);
        userField = new JTextField();
        userField.setBounds(125, 50, 150, 25);
        userField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        getContentPane().add(userField);
        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 85, 90, 25);
        passLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        getContentPane().add(passLabel);
        passField = new JPasswordField();
        passField.setBounds(125, 85, 150, 25);
        passField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        getContentPane().add(passField);
        loginButton = new JButton("Log in");
        loginButton.setBounds(90,140,100,40);
        getContentPane().add(loginButton);

        //this.setVisible(true);
    }

    public JTextField getUserField() {
        return userField;
    }

    public JTextField getPassField() {
        return passField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}