package Entities;

import java.awt.List;
import java.util.ArrayList;

public class UserRestaurant extends User {
    private String cnpj;

    // private List<Snack> menu = new ArrayList<>();
    // private List<Order> orderRestaurant = new ArrayList<>();

    public UserRestaurant(int positionX, int positionY, String password, String name, String cnpj){
        super(positionX, positionY, password, name); // Gets the attributes of the parent class
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // private List<Snack> getMenu(List menu){
    //     return menu;
    // }

    // private List<Order> getOrderRestaurant(List orderRestaurant){
    //     return orderRestaurant;
    // }

    public void printMenu(){

    }

    public void addSnack(){

    }

    public void removeSnack(){

    }
}
