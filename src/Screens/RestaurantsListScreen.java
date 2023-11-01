package Screens;
import Components.Button;
import java.awt.Container;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RestaurantsListScreen extends JFrame {
    Button btnHome;
    JLabel background;

    Container frame = getContentPane();

    public RestaurantsListScreen(){
        super("App Delivery - List Restaurants");
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

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/lista_de_restaurantes.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        // Create and add action listener to the button home
        btnHome = createButton(background, 40, 37, 34, 34);
        frame.add(btnHome);
        btnHome.addActionListener(e -> showHomeScreen());
    }

    public void open() {
        RestaurantsListScreen frame = new RestaurantsListScreen();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterRestaurantScreen::new);
    }
}
