package Screens;
import Components.Button;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

import javax.swing.SwingUtilities;

public class LoginRestaurantScreen extends JFrame {
    Button btnLogin, btnHome;
    JLabel background;
    ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/login_do_restaurante.png")));

    public LoginRestaurantScreen (){
        super("App Delivery - Login Restaurant");
        Container frame = getContentPane();
        frame.setLayout(null);

        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        btnLogin = new Button();
        btnLogin.setBounds(219, 282, 201, 35);
        frame.add(btnLogin);

        btnHome = new Button();
        btnHome.setBounds(35, 252, 34, 34);
        frame.add(btnHome);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(656, 480);
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void showHomeScreen() {
        System.out.println("Chamando showHomeScreen()");
        dispose(); // Close the current screen
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginRestaurantScreen::new);
    }
}
