package Screens;
import Components.Button;

import java.awt.Container;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HomeScreen extends JFrame {
    private Button btnLoginRestaurant, btnLoginClient;
    private Button btnRegisterRestaurant, btnRegisterClient;
    private JLabel background;

    public HomeScreen() {
        super("App Delivery");
        initializeComponents(); 
    }

    public Button createButton(Container container, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        container.add(button);
        return button;
    }

    private void initializeComponents() {
        Container frame = getContentPane();
        frame.setLayout(null);

        // Load the background image
        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/pagina_inicial.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -30, 1006, 757);
        frame.add(background);

        // Buttons for changing screens
        btnLoginRestaurant = createButton(frame, 219, 494, 124, 35);
        btnRegisterRestaurant = createButton(frame, 349, 494, 124, 35);
        btnLoginClient = createButton(frame, 519, 494, 124, 35);
        btnRegisterClient = createButton(frame, 649, 494, 124, 35);

        // Add action listeners to the buttons
        btnLoginRestaurant.addActionListener(e -> showLoginRestaurantScreen());
        btnRegisterRestaurant.addActionListener(e -> showRegisterRestaurantScreen());
        btnLoginClient.addActionListener(e -> showLoginClientScreen());
        btnRegisterClient.addActionListener(e -> showRegisterClientScreen());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1006, 757);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(null);
        setVisible(true);
    }

    private void showLoginRestaurantScreen() {
        dispose(); // Close the current screen
        LoginRestaurantScreen loginRestaurant = new LoginRestaurantScreen();
        loginRestaurant.open();
    }

    private void showRegisterRestaurantScreen() {
        dispose(); // Close the current screen
        RegisterRestaurantScreen registerRestaurant = new RegisterRestaurantScreen();
        registerRestaurant.open();
    }

    private void showLoginClientScreen() {
        dispose(); // Close the current screen
        LoginClientScreen loginClient = new LoginClientScreen();
        loginClient.open();
    }

    private void showRegisterClientScreen() {
        dispose(); // Close the current screen
        RegisterClientScreen registerClient = new RegisterClientScreen();
        registerClient.open();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
    }
}
