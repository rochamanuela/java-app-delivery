package Components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(){
        super();
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}