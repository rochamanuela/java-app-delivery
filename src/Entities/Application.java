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
        
        Client defaultClient = new Client(null, "adminClient" , "admin123", 0, 0);
        Client manu = new Client(null, "manu" , "manu123", 0, 0);
        Restaurant defaultRestaurant = new Restaurant(null, "adminRestaurant", "admin123", 0, 0);
        
        clients.add(defaultClient);
        clients.add(manu);
        
        restaurants.add(defaultRestaurant);
        
        LoginClientScreen loginClient = new LoginClientScreen();
        loginClient.initializeComponents();
    }
}