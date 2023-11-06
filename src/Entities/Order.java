package Entities;

import java.util.ArrayList;

public class Order {
    public static ArrayList<Dish> orderItems;
    
    public Order(){
        orderItems = new ArrayList<>();
    }

    public static ArrayList<Dish> getOrderItems() {
        return orderItems;
    }

    public static void setOrderItems(ArrayList<Dish> orderItems) {
        Order.orderItems = orderItems;
    }
    
    public double makeOrder() {
        // post-it realização de pedidos e cálculo do valor dos alimentos

        double totalItems = 0.0;

        for (Dish item : orderItems) {
            totalItems = totalItems + item.getPrice();
        }

        return totalItems;
    }
    
    public double calculateDeliveryFee() {
        double distance, distanceX, distanceY, fee;
        
        int[] adressClient = {0, 10};
        int[] adressRestaurant = {8, 0};
        
        distanceX = Math.abs(adressClient[0] - adressRestaurant[0]);
        distanceY = Math.abs(adressClient[1] - adressRestaurant[1]);
        distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        
        fee = 2 + (distance * 0.5);
        
        return fee;
    }
    
    public double calculateTotal () {
        // vai usar o resultados vindos de makeOrder() e de calculateDeliveryFee()
        double fee = calculateDeliveryFee();
        double itens = makeOrder();
        double totalPurchase = fee + itens;

        return totalPurchase;
    }

    public void printStrokes() {
        for (int i = 0; i < 25; i++) 
            System.out.print("-=");
    }

    public void printOrder() {
        // post-it emissão da NF

        printStrokes();
        System.out.format("%-30s%-15s%n", "Item", "Valor");
        for (Dish item : orderItems) {
            System.out.format("%-30s%-15s%n", item.getName(), "R$ " + item.getPrice());
        }
        printStrokes();

        String totalItems = String.format("%-30s%-15s%n", "Valor dos itens", "R$ %.2f" + makeOrder());
        System.out.println(totalItems);

        String feeText = String.format("%-30s%-15s%n", "Taxa de entrega", "R$ %.2f" + calculateDeliveryFee());
        System.out.println(feeText);

        String totalPurchase = String.format("%-30s%-15s%n", "Total da compra", "R$ %.2f" + calculateTotal());
        System.out.println(totalPurchase);
    }
}
