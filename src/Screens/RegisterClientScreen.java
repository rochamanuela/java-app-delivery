package Screens;
import Components.Button;
import Components.Input;
import Entities.Application;
import Entities.Client;

import java.awt.Container;
import java.util.Objects;

import javax.swing.*;

public class RegisterClientScreen extends JFrame {
    Button btnRegister, btnHome, btnRestaurant;
    Input passwordInput, nameInput, cpfInput, xInput, yInput;
    JLabel background;

    Container frame = getContentPane();

    public RegisterClientScreen(){
        super("App Delivery - Register Client");
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

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/cadastrar_cliente.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        String placeholderText = "Digite algo aqui";
        nameInput = createInput(background, 298, 109, 289, 35, placeholderText);
        cpfInput = createInput(background, 298, 174, 163, 35, "cpf");
        passwordInput = createInput(background, 450, 174, 163, 35, "senha");
        xInput = createInput(background, 298, 237, 163, 35, "x");
        yInput = createInput(background, 450, 237, 163, 35, "y");

        btnRegister = createButton(background, 298, 288, 300, 35);
        btnHome = createButton(background, 40, 37, 34, 34);
        btnRestaurant = createButton(background, 258, 415, 24, 24);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());
        btnRestaurant.addActionListener(e -> showRegisterRestaurantScreen());

        btnRegister.addActionListener(e -> {
            //recovery of the fields
            String name = nameInput.getText();
            String cpf = cpfInput.getText();
            String password = passwordInput.getText();
            int x, y;

            try {
                x = Integer.parseInt(xInput.getText());
                y = Integer.parseInt(yInput.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores inteiros válidos para x e y.");
                return;
            }

            if (name.isEmpty() || cpf.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos");
            }

            else{
                Client client = new Client(name, cpf, password, x, y);
                Application.clients.add(client);

                // starting the section before switching screens, so that the login is not lost
                Application.clientSession = client;

                dispose(); // Close the current screen
                showListRestaurants(); // Show restaurants list screen
            }
        });
    }

    public void open() {
        RegisterClientScreen frame = new RegisterClientScreen();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(656, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void showHomeScreen() {
        dispose(); // Close the current screen
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
    }

    private void showListRestaurants() {
        RestaurantsListScreen restaurantsList = new RestaurantsListScreen();
        restaurantsList.open();
    }

    private void showRegisterRestaurantScreen() {
        dispose(); // Close the current screen
        RegisterRestaurantScreen registerRestaurantScreen = new RegisterRestaurantScreen();
        registerRestaurantScreen.open();
    }
}
