package Entities;

public class Order {
    private int number, positionX, positionY;
    private double price;
    private String nameClient;
    
    public Order(int number, int positionX, int positionY, double price, String nameClient) {
        this.number = number;
        this.positionX = positionX;
        this.positionY = positionY;
        this.price = price;
        this.nameClient = nameClient;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}
