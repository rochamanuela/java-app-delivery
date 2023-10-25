package Entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return password.equals(client.getPassword()) && cpf.equals(client.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getCpf());
    }
}
