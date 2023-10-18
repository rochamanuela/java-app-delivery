import javax.swing.SwingUtilities;

import Entities.UserClient;
import Entities.UserRestaurant;
import Screens.HomeScreen;

public class Application {
    // public static void main(String[] args) {
    //     UserClient userClient = new UserClient(200, 200, "client123", "Manuela", "11122233344");
    //     UserRestaurant userRestaurant = new UserRestaurant(150, 150, "restaurant123", "BK", "XXXXXXXX0001XX");
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
        
    }


}
