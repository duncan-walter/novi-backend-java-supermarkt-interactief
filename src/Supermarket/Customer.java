package Supermarket;

public class Customer {
    public String name;
    public Supermarket superMarket;

    public Customer(String name) {
        this.name = name;
    }

    public void goToSuperMarket(Supermarket superMarket) {
        this.superMarket = superMarket;
        System.out.printf("%s entered %s.%n", name, superMarket.name);
    }

    public void buyItem(String productName, int amount) {
        if (superMarket == null) {
            System.out.printf("%s is currently not in a supermarket, please visit a supermarket first.%n", name);
            return;
        }

        for (int i = 0; i < superMarket.productCatalogue.size(); i++) {
            Product product = superMarket.productCatalogue.get(i);
            if (product.name.equalsIgnoreCase(productName)) {
                superMarket.buyItem(product, amount);
                return;
            }
        }

        System.out.printf("%s can't find any '%s' among the shelves at %s.%n", name, productName, superMarket.name);
    }
}