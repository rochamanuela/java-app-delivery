/*package Entities;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Screens.HomeScreen;
import Screens.LoginClientScreen;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Dish> dishs = new ArrayList<>();

        // public void registerRestaurant() { }
        // public void registerClient() { }

        Client client1 = new Client("João", "123456789", "senha123", 0, 0);
        clients.add(client1);

        Client client2 = new Client("Maria", "987654321", "senha456", 0, 0);
        clients.add(client2);

        System.out.println("vc aguenta");
    }
}*/

package Entities;

import Screens.LoginClientScreen;

import java.util.ArrayList;

public class Application {
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<Restaurant> restaurants = new ArrayList<>();

    public static Restaurant restaurantSession;
    public static Client clientSession;

    public static ArrayList<Dish> dishes = new ArrayList<>();
    
    public Application() {
        /* code arprigio 
        LoginScreen start = new LoginScreen();
        start.openLoginScreen();
        User userAdmin = new User("adminClient", "admin123", 0, 0);
        Restaurant resAdmin = new Restaurant("adminRestaurant", "res123", 0, 0);
        clients.add(userAdmin);
        restaurants.add(resAdmin);*/

        
        Client defaultClient = new Client(null, "adminClient" , "admin123", 0, 0);
        Restaurant defaultRestaurant = new Restaurant(null, "adminRestaurant", "admin123", 0, 0);

        clients.add(defaultClient);
        restaurants.add(defaultRestaurant);

        LoginClientScreen loginClient = new LoginClientScreen();
        loginClient.initializeComponents();

        
    }
}