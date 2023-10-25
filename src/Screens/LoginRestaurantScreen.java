package Screens;
import Components.Button;
import Components.Input;
import Entities.Application;
import Entities.Client;
import Entities.Restaurant;

import java.awt.Container;
import java.util.Objects;

import javax.swing.*;

public class LoginRestaurantScreen extends JFrame {
    Button btnLogin, btnHome, btnInfos;
    Input cnpjInput, passwordInput;
    JLabel background;

    Container frame = getContentPane();

    public LoginRestaurantScreen(){
        super("App Delivery - Login Restaurant");
        initializeComponents();
    }

    public Button createButton(JLabel label, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        label.add(button);
        return button;
    }

    public Input createInput (JLabel label, int x, int y, int width, int height, String text) {
        Input input = new Input(text);
        input.setBounds(x, y, width, height);
        label.add(input);
        return input;
    }

    private void initializeComponents(){
        frame.setLayout(null);

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/login_do_restaurante.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        String placeholderText = "Digite algo aqui";
        cnpjInput = createInput(background, 235, 181, 190, 35, placeholderText);
        passwordInput = createInput(background, 235, 246, 190, 35, "senha");

        btnLogin = createButton(background, 219, 301, 201, 35);
        btnHome = createButton(background, 40, 37, 34, 34);
        btnInfos = createButton(background, 515, 419, 111, 24);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());
        btnInfos.addActionListener(e -> showInfosScreen());

        // Add action listener to functional buttos: Login
        btnLogin.addActionListener(e -> {
            String cnpj = cnpjInput.getText();
            String password = passwordInput.getText();

            System.out.println("CNPJ: " + cnpj + " Senha: " + password);

            Restaurant loginRestaurant = new Restaurant(null, cnpj, password, 0, 0);
            if (Application.restaurants.contains(loginRestaurant)) {
                System.out.println("Login bem-sucedido");

                dispose(); // Close the current screen
                showHomeRestaurant(); // Show home restaurant screen
            }

            else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        });
    }

    public void open(){
        LoginRestaurantScreen frame = new LoginRestaurantScreen();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(656, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void showHomeRestaurant() {
        HomeRestaurantScreen homeRestaurant = new HomeRestaurantScreen();
        homeRestaurant.open();
    }

    private void showHomeScreen() {
        dispose(); // Close the current screen
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
    }

    private void showInfosScreen() {
        dispose(); // Close the current screen
        InfosScreen infosScreen = new InfosScreen();
        infosScreen.setVisible(true);
    }
}
