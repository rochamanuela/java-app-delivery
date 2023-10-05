package Screens;

import Components.Button;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private Button createButton(Container container, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        container.add(button);
        return button;
    }

    private void initializeComponents() {
        Container frame = getContentPane();
        frame.setLayout(null);

        // Load the background image
        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/1_home_screen.png")));
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

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1006, 757);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(null);
        setVisible(true);
    }

    private void showLoginRestaurantScreen() {
        dispose(); // Close the current screen
        LoginRestaurantScreen loginRestaurant = new LoginRestaurantScreen();
        loginRestaurant.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
    }
}
