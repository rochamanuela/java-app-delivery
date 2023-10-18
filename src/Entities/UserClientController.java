package Entities;
import java.util.ArrayList;

public class UserClientController {
    private ArrayList<UserClient> clients;

    public UserClientController() {
        clients = new ArrayList<>();
    }

    public boolean registerUserClient(String name, int positionX, int positionY, String cpf, String password) {
        for (UserClient client : clients) {
            if (client.getCpf().equals(cpf)) {
                return false;
            }
        }

        UserClient newClient = new UserClient(positionY, positionX, password, name, cpf);
        clients.add(newClient);
        return true;
    }

    public boolean loginUserClient(String cpf, String password) {
        for (UserClient client : clients) {
            if (client.getCpf().equals(cpf) && client.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
