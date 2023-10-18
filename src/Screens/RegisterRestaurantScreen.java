package Screens;
import Components.Button;
import Components.Input;

import java.awt.Container;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RegisterRestaurantScreen extends JFrame {
    Button btnRegister, btnHome, btnClient;
    Input senhaInput, nameInput, cnpjInput, xInput, yInput;
    JLabel background;

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
        Container frame = getContentPane();
        frame.setLayout(null);

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/cadastrar_restaurante.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        String placeholderText = "Digite algo aqui";
        nameInput = createInput(background, 298, 109, 289, 35, placeholderText);
        cnpjInput = createInput(background, 298, 174, 163, 35, "cnpj");
        senhaInput = createInput(background, 450, 174, 163, 35, "senha");
        xInput = createInput(background, 298, 237, 163, 35, "x");
        yInput = createInput(background, 450, 237, 163, 35, "y");

        btnRegister = createButton(background, 298, 288, 300, 35);
        btnHome = createButton(background, 40, 37, 34, 34);
        btnClient = createButton(background, 322, 415, 24, 24);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());
        btnClient.addActionListener(e -> showRegisterClientScreen());

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

    private void showRegisterClientScreen() {
        dispose(); // Close the current screen
        RegisterClientScreen registerClientScreen = new RegisterClientScreen();
        registerClientScreen.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterRestaurantScreen::new);
    }
}
