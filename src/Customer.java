public class Customer {
    public String name;
    public SuperMarket superMarket;

    public Customer(String name) {
        this.name = name;
    }

    public void goToSuperMarket(SuperMarket superMarket) {
        this.superMarket = superMarket;
        System.out.printf("%s entered %s.", name, superMarket.name);
    }

    public void buyItem(String productName, int amount) {
        if (superMarket == null) {
            System.out.printf("%s is currently not in a supermarket, please visit a supermarket first.", name);
            return;
        }

        for (int i = 0; i < superMarket.productCatalogue.size(); i++) {
            Product product = superMarket.productCatalogue.get(i);
            if (product.name.equalsIgnoreCase(productName)) {
                superMarket.buyItem(product, amount);
                return;
            }
            System.out.printf("%s is currently not available in %s, try buying another product.", productName, superMarket.name);
        }
    }
}