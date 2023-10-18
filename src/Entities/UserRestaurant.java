package Entities;

public class UserRestaurant extends User {
    private String cnpj;

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
}
