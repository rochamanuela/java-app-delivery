package Entities;

import java.util.ArrayList;

import Screens.HomeScreen;

public class Application {
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<Restaurant> restaurants = new ArrayList<>();

    public static Restaurant restaurantSession;
    public static Client clientSession;

    public static ArrayList<Dish> dishes = new ArrayList<>();
    
    public Application() {
        
        Client defaultClient = new Client(null, "adminClient" , "admin123", 0, 0);
        Restaurant defaultRestaurant = new Restaurant(null, "adminRestaurant", "admin123", 0, 0);
                
        clients.add(defaultClient);        
        restaurants.add(defaultRestaurant);

        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
    }
}