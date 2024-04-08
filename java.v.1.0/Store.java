import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product) {}

public class Store {
    private static ArrayList<ProductForSale> storeProduct = new ArrayList<>();

    public static void main(String[] args) {
        storeProduct.add(new ArtObject("Oil Painting", 1350, "Impressionistic work by ABF painted in 2010"));
        storeProduct.add(new ArtObject("Sculpture", 2000, "Bronze work by JKF, produced in 1950"));
        storeProduct.add(new Furniture("Desc", 500, "Mahogany Desc"));
        storeProduct.add(new Furniture("Lamp", 200, "Tiffany Lamp with Hummingbirds"));
        listProduct();

        System.out.println("\nOrder1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);
        System.out.println("\nOrder2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    }

    public static void listProduct() {
        for (var item : storeProduct) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty) {
        order.add(new OrderItem(qty, storeProduct.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double saleTotal = 0;
        for (var item : order) {
            item.product().printPriceItem(item.qty());
            saleTotal += item.product().getSalePrice(item.qty());
        }
        System.out.printf("Sales Total = %6.2f %n", saleTotal);
    }
}
