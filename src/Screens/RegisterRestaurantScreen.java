package Screens;
import Components.Button;
import Components.Input;
import Entities.Application;
import Entities.Restaurant;

import java.awt.Container;
import java.util.Objects;

import javax.swing.*;

public class RegisterRestaurantScreen extends JFrame {
    Button btnRegister, btnHome, btnClient;
    Input passwordInput, nameInput, cnpjInput, xInput, yInput;
    JLabel background;

    Container frame = getContentPane();

    public RegisterRestaurantScreen(){
        super("App Delivery - Register Restaurant");
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

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/cadastrar_restaurante.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        String placeholderText = "Digite algo aqui";
        nameInput = createInput(background, 298, 113, 289, 35, placeholderText);
        cnpjInput = createInput(background, 298, 178, 163, 35, "cnpj");
        passwordInput = createInput(background, 450, 178, 163, 35, "senha");
        xInput = createInput(background, 298, 241, 163, 35, "x");
        yInput = createInput(background, 450, 241, 163, 35, "y");

        btnRegister = createButton(background, 298, 288, 300, 35);
        btnHome = createButton(background, 40, 37, 34, 34);
        btnClient = createButton(background, 322, 415, 24, 24);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());
        btnClient.addActionListener(e -> showRegisterClientScreen());

        btnRegister.addActionListener(e -> {
            //recovery of the fields
            String name = nameInput.getText();
            String cnpj = cnpjInput.getText();
            String password = passwordInput.getText();
            int x, y;

            try {
                x = Integer.parseInt(xInput.getText());
                y = Integer.parseInt(yInput.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores inteiros válidos para x e y.");
                return;
            }

            if (name.isEmpty() || cnpj.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos");
            }

            else{
                Restaurant restaurant = new Restaurant(name, cnpj, password, x, y);
                Application.restaurants.add(restaurant);

                dispose(); // Close the current screen
                showHomeRestaurant(); // Show restaurants list screen
            }
        });
    }

    public void open() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(656, 480);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
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

    private void showRegisterClientScreen() {
        dispose(); // Close the current screen
        RegisterClientScreen registerClientScreen = new RegisterClientScreen();
        registerClientScreen.open();
    }
}