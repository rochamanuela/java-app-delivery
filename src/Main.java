import Screens.HomeScreen;
import Screens.LoginRestaurantScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame();
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // The card layout component allows the exchange of other components, thus serving to switch screens in Java Swing
            JPanel cardPanel = new JPanel(new CardLayout());

            HomeScreen homeScreen = new HomeScreen();
            LoginRestaurantScreen loginRestaurantScreen = new LoginRestaurantScreen();

            cardPanel.add(homeScreen);
            cardPanel.add(loginRestaurantScreen);


        });
    }
}
