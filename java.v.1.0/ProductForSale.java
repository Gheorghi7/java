public abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String descriptiom;

    public ProductForSale(String type, double price, String descriptiom) {
        this.type = type;
        this.price = price;
        this.descriptiom = descriptiom;
    }

    public void printPriceItem(int qty) {
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n", qty, price, type, descriptiom);
    }

    public double getSalePrice(int qty) {
        return qty * price;
    }

    abstract void showDetails();
}

class ArtObject extends ProductForSale {

    public ArtObject(String type, double price, String descriptiom) {
        super(type, price, descriptiom);
    }

    @Override
    void showDetails() {
        System.out.println("This " + type + " is a beautiful reproduction");
        System.out.printf("The price of the piece is $%6.2f %n", price);
        System.out.println(descriptiom);
    }
}

class Furniture extends ProductForSale {

    public Furniture(String type, double price, String descriptiom) {
        super(type, price, descriptiom);
    }


    @Override
    void showDetails() {
        System.out.println("This " + type + " was manufactured in North Carolina");
        System.out.printf("The price of the piece is $%6.2f %n", price);
        System.out.println(descriptiom);
    }
}
