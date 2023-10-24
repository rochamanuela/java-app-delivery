package Entities;

public class Restaurant {
    private String name, cnpj, password;
    private int positionX, positionY;

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

    public void printMenu(){

    }

    public void addSnack(){

    }

    public void removeSnack(){

    }
}
