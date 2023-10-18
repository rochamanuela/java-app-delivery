import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Entities.Restaurant;
import Entities.UserClient;
import Screens.HomeScreen;
import Screens.LoginClientScreen;

public class Application {
    // public static void main(String[] args) {
    //     UserClient userClient = new UserClient(200, 200, "client123", "Manuela", "11122233344");
    //     UserRestaurant userRestaurant = new UserRestaurant(150, 150, "restaurant123", "BK", "XXXXXXXX0001XX");
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
        
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        ArrayList<UserClient> clients = new ArrayList<>();
        
        JFrame frame = new JFrame("");
        JLabel label = new JLabel(null, null, 0);

        restaurants.add(new Restaurant(0, 0, null, null, null));
        
        label.setText(restaurants.get(0).getName());
        LoginClientScreen.btn.addActionListener(e -> funcao());
        frame.add(frame, label, 0);
        



    }

    // public static void funcao(){
    //     String x = input.getText();
    // }

    /*
    Restaurant.cadastrarlanche(a,b,c,d)
    String x = input.gegtext 

    .add(new Restaurante)
    */

}
