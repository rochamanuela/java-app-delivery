package Entities;

public class Client {
    // this is the class that corresponds to the user class
    private String name, cpf, password;
    private int positionX, positionY;
    
    public Client(String name, String cpf, String password, int positionX, int positionY) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
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
}
