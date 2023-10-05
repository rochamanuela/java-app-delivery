package Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Input extends JTextField {
    public Input(){
        super();
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setForeground(new Color(31,31,31));
        this.setFont(new Font("Arial", Font.PLAIN, 14));

        //Font.decode("Helvetica")
    }
}
