package Screens;
import Components.Button;
import Components.Input;

import java.awt.Container;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RegisterDishScreen extends JFrame {
    Button btnAddDish, btnHome;
    Input nameDishInput, priceDishInput;
    JLabel background;

    public RegisterDishScreen(){
        super("App Delivery - Dish");
        initializeComponents();
    }

    public Input createInput (JLabel label, int x, int y, int width, int height, String text) {
        Input input = new Input(text);
        input.setBounds(x, y, width, height);
        label.add(input);
        return input;
    }

    public Button createButton(JLabel label, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        label.add(button);
        return button;
    }

    private void initializeComponents(){
        Container frame = getContentPane();
        frame.setLayout(null);

        ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("../Images/cadastrar_prato.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        nameDishInput = createInput(background, 105, 188, 163, 35, "");
        priceDishInput = createInput(background, 290, 188, 107, 35, "");

        btnHome = createButton(background, 40, 37, 34, 34);
        btnAddDish = createButton(background, 405, 183, 143, 35);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterDishScreen::new);
    }
}
