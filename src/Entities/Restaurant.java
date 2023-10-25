package Entities;

import java.util.ArrayList;
import java.util.Objects;

public class Restaurant {
    private String name, cnpj, password;
    private int positionX, positionY;
    public ArrayList<Dish> dishes = new ArrayList<>();

    public Restaurant(String name, String cnpj, String password, int positionX, int positionY) {
        this.name = name;
        this.cnpj = cnpj;
        this.password = password;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getPassword() {
        return password;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return password.equals(restaurant.getPassword()) && cnpj.equals(restaurant.getCnpj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getCnpj());
    }

    public void printMenu(){

    }

    public void addSnack(){

    }

    public void removeSnack(){

    }
}
