package Screens;
import Components.Button;

import java.awt.Container;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HomeRestaurantScreen extends JFrame {
    Button btnDish, btnResume, btnHome;
    JLabel background;

    Container frame = getContentPane();

    public HomeRestaurantScreen(){
        super("App Delivery - Home");
        initializeComponents();
    }

    public Button createButton(JLabel label, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        label.add(button);
        return button;
    }

    private void initializeComponents(){
        frame.setLayout(null);

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/inicial_restaurante.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        btnHome = createButton(background, 40, 37, 34, 34);
        btnDish = createButton(background, 329, 219, 201, 35);
        btnResume = createButton(background, 329, 264, 201, 35);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());
        btnDish.addActionListener(e -> showRegisterDishScreen());
    }

    public void open() {
        HomeRestaurantScreen frame = new HomeRestaurantScreen();
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

    private void showRegisterDishScreen() {
        dispose(); // Close the current screen
        RegisterDishScreen registerDishScreen = new RegisterDishScreen();
        registerDishScreen.open();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeRestaurantScreen::new);
    }
}
