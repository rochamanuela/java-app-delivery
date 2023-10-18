package Entities;

public class UserClient extends User {
    private String cpf;

    public UserClient(int positionX, int positionY, String password, String name, String cpf){
        super(positionX, positionY, password, name); // Gets the attributes of the parent class
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
