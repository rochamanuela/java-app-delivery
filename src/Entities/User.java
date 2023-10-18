package Entities;

public class User {
    private int positionX, positionY;
    private String password, name;

    public User(int positionX, int positionY, String password, String name){
        this.positionX = positionX;
        this.positionY = positionY;
        this.password = password;
        this.name = name;
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
