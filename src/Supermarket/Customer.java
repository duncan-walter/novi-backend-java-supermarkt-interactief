package Supermarket;

public class Customer {
    public String name;
    public Supermarket supermarket;

    public Customer(String name) {
        this.name = name;
    }

    public void goToSuperMarket(Supermarket supermarket) {
        this.supermarket = supermarket;
        System.out.printf("%s entered %s.%n", name, supermarket.name);
    }

    public void buyItem(String productName, int amount) {
        if (supermarket == null) {
            System.out.printf("%s is currently not in a supermarket, please visit a supermarket first.%n", name);
            return;
        }

        for (int i = 0; i < supermarket.productCatalogue.size(); i++) {
            Product product = supermarket.productCatalogue.get(i);
            if (product.name.equalsIgnoreCase(productName)) {
                supermarket.buyItem(product, amount);
                return;
            }
        }

        System.out.printf("%s can't find any '%s' among the shelves at %s.%n", name, productName, supermarket.name);
    }
}