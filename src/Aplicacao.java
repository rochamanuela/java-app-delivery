import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Aplicacao extends JFrame implements ActionListener {
    ImageIcon wallpaper = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/tela_inicial.png")));
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
