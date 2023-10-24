package Entities;

import java.util.ArrayList;

public class Order {
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    
    public Order(ArrayList<Restaurant> restaurants, ArrayList<Client> clients) {
        this.restaurants = restaurants;
        this.clients = clients;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
    
    public void makeOrder() {

    }

    public void printOrder() {
        
    }
}
