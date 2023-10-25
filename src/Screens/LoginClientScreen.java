package Screens;

import Components.Button;
import Components.Input;
import Entities.Application;
import Entities.Client;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LoginClientScreen extends JFrame {
    Button btnLogin, btnHome, btnInfos;
    Input cpfInput, passwordInput;
    JLabel background;

    public LoginClientScreen() {
        super("App Delivery - Login Client");
        initializeComponents();
    }

    public Button createButton(JLabel label, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        label.add(button);
        return button;
    }

    public Input createInput(JLabel label, int x, int y, int width, int height, String text) {
        Input input = new Input(text);
        input.setBounds(x, y, width, height);
        label.add(input);
        return input;
    }

    public void initializeComponents() {
        Container frame = getContentPane();
        frame.setLayout(null);

        ImageIcon wallpaper = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("../Images/login_do_cliente.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        String placeholderText = "Digite algo aqui";
        cpfInput = createInput(background, 235, 181, 190, 35, placeholderText);
        passwordInput = createInput(background, 235, 246, 190, 35, "senha");

        btnLogin = createButton(background, 219, 301, 201, 35);
        btnHome = createButton(background, 40, 37, 34, 34);
        btnInfos = createButton(background, 515, 419, 111, 24);

        // Add action listeners to the "static" buttons
        btnHome.addActionListener(e -> showHomeScreen());
        btnInfos.addActionListener(e -> showInfosScreen());

        // Add action listener to functional buttos: Login
        btnLogin.addActionListener(e -> {
            String cpf = cpfInput.getText();
            String password = passwordInput.getText();

            System.out.println("CPF: " + cpf + " Senha: " + password);

            Client loginClient = new Client(null, cpf, password, 0, 0);
            if (Application.clients.contains(loginClient)) {
                System.out.println("Login bem-sucedido");

                dispose(); // Close the current screen
                InfosScreen infosScreen = new InfosScreen();
                infosScreen.setVisible(true);
            }

            else {
                // Login falhou
                // Exiba uma mensagem de erro ou ação apropriada
                System.out.println("o login deu ruim");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(656, 480);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginClientScreen::new);
    }
}
