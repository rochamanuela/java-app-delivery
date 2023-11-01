package Screens;

import Components.Button;
import Components.Input;
import Entities.Application;
import Entities.Dish;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class RegisterDishScreen extends JFrame {
    Button btnAddDish, btnHome;
    Input nameDishInput, priceDishInput;
    JLabel background;

    Container frame = getContentPane();

    private ArrayList<Dish> dishList = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable table;

    public RegisterDishScreen() {
        super("App Delivery - Dish");
        initializeComponents();
    }

    public Input createInput(JLabel label, int x, int y, int width, int height, String text) {
        Input input = new Input(text);
        input.setBounds(x, y, width, height);
        label.add(input);
        return input;
    }

    public Button createButton(JLabel label, int x, int y, int width, int height) {
        Button button = new Button();
        button.setBounds(x, y, width, height);
        label.add(button);
        return button;
    }

    private void initializeComponents() {
        frame.setLayout(null);

        ImageIcon wallpaper = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("../Images/cadastrar_prato.png")));
        background = new JLabel(wallpaper);
        background.setBounds(-5, -20, 656, 480);
        frame.add(background);

        // -------------------------------------------------
        // teste para a tabela de pratos adicionados (visão restaurante)
        String[] columns = { "Nome", "Preço", "Excluir" };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        background.add(new JScrollPane(table));
        // -------------------------------------------------

        nameDishInput = createInput(background, 105, 188, 163, 35, "");
        priceDishInput = createInput(background, 290, 188, 107, 35, "");

        btnHome = createButton(background, 40, 37, 34, 34);
        btnAddDish = createButton(background, 405, 183, 143, 35);

        // Add action listeners to the buttons
        btnHome.addActionListener(e -> showHomeScreen());

        btnAddDish.addActionListener(e -> {
            // recovery of the fields
            String name = nameDishInput.getText();
            double price;

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, defina um nome para seu prato.");
                return;
            }

            try {
                price = Double.parseDouble(priceDishInput.getText());
                if (price <= 0) {
                    JOptionPane.showMessageDialog(null, "O preço do prato deve ser um valor positivo válido.");
                    return;
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico para o preço do prato.");
                return;
            }

            if (Application.restaurantSession != null) {
                if (Application.restaurantSession.dishes != null) {
                    // adicionando o prato na lista da classe Dish
                    Dish dish = new Dish(name, price);
                    Application.restaurantSession.dishes.add(dish);

                    // adicionando o prato na lista local
                    dishList.add(dish);
                    updateList();
                } else {
                    System.out.println("Erro ao executar a operação. A lista de pratos é nula");
                }
            } else {
                System.out.println("Erro ao executar a operação. RestaurantSession é nulo.");
            }

        });
    }

    private void updateList() {
        tableModel.setRowCount(0);
        for (Dish dish : dishList) {
            tableModel.addRow(new Object[] { dish.getName(), dish.getPrice(), "Excluir" });

            System.out.println(dish.getName() + " --- " + dish.getPrice());
        }

        table.revalidate();
        table.repaint();
    }

    public void open() {
        RegisterDishScreen frame = new RegisterDishScreen();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(656, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void showHomeScreen() {
        dispose(); // Close the current screen
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(RegisterDishScreen::new);
        // RegisterDishScreen teste = new RegisterDishScreen();
        // teste.open();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegisterDishScreen screen = new RegisterDishScreen();
                screen.open();
            }
        });
    }
}
