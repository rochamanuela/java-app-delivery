import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Entities.Client;
import Entities.Dish;
import Entities.Restaurant;
import Screens.HomeScreen;
import Screens.LoginClientScreen;

public class Application {
    
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Dish> dishs = new ArrayList<>();

    public void registerRestaurant() {

    }

    public void registerClient() {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
    }
}
