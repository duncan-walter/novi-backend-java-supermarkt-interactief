package Supermarket;

import java.util.*;

public class SupermarketSimulation {
    private final static int PRODUCTS_PER_SUPERMARKET = 4;
    private final static String[] SUPERMARKET_NAMES = {"Halbert Ein", "Dumbo", "Wally"};

    private final List<Product> availableProducts = new ArrayList<>();
    private final Map<String, Supermarket> supermarkets = new HashMap<>();
    private final Customer customer = new Customer("Duncan");
    private final Scanner scanner = new Scanner(System.in);

    public SupermarketSimulation() {
        populateProducts();
        populateSupermarkets();
    }

    public void simulate() {
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1 - Visit a supermarket");
            System.out.println("2 - Buy a product");
            System.out.println("3 - Restock a product");
            System.out.println("4 - Exit");

            String userMenuChoice = scanner.nextLine();

            switch (userMenuChoice) {
                case "1":
                    Supermarket supermarketToVisit = getUserSupermarketChoice("Which supermarket would you like to visit?");
                    customer.goToSuperMarket(supermarketToVisit);

                    break;
                case "2":
                    if (customer.supermarket == null) {
                        System.out.println("Please visit a supermarket first before trying to buy a product!");
                        break;
                    }

                    System.out.printf("What product would you like to buy from %s?%n", customer.supermarket.name);
                    String targetProduct = scanner.nextLine();

                    System.out.printf("How many %s(s) would you like to buy?%n", targetProduct);
                    int targetAmount = scanner.nextInt();
                    scanner.nextLine();

                    customer.buyItem(targetProduct, targetAmount);

                    break;
                case "3":
                    Supermarket supermarketToRestock = getUserSupermarketChoice("Which supermarket would you like to restock?");

                    System.out.printf("What product would you like to restock to %s?%n", supermarketToRestock.name);
                    String itemToRestock = scanner.nextLine();

                    System.out.printf("How many %s(s) would you like to restock?%n", itemToRestock);
                    int restockAmount = scanner.nextInt();
                    scanner.nextLine();

                    supermarketToRestock.restockItem(itemToRestock, restockAmount);

                    break;
                case "4":
                    System.out.println("Farewell!");

                    return;
                default:
                    System.out.printf("%s is not a valid option! Please pick a valid option.%n", userMenuChoice);

                    break;
            }
        }
    }

    private void populateProducts() {
        availableProducts.add(new Product("Frikandelbroodje", 0.99, 10));
        availableProducts.add(new Product("Kiwi", 2, 50));
        availableProducts.add(new Product("0,5-laags toiletpapier", 5, 100));
        availableProducts.add(new Product("Cheddar", 2.5, 10));
        availableProducts.add(new Product("Melk", 1, 100));
        availableProducts.add(new Product("Banaan", 0.5, 500));
        availableProducts.add(new Product("1-laags toiletpapier", 10, 10));
        availableProducts.add(new Product("Oude kaas", 5, 5));
        availableProducts.add(new Product("Pepernoten", 2, 100));
        availableProducts.add(new Product("Doperwten", 2, 50));
        availableProducts.add(new Product("2-laags toiletpapier", 10, 100));
        availableProducts.add(new Product("Croissant", 0.25, 100));
    }

    private void populateSupermarkets() {
        for (String supermarketName : SUPERMARKET_NAMES) {
            int randomIndex = (int)(Math.random() * (availableProducts.size() - PRODUCTS_PER_SUPERMARKET + 1));
            Supermarket supermarket = new Supermarket(
                    supermarketName,
                    availableProducts.subList(randomIndex, randomIndex + PRODUCTS_PER_SUPERMARKET)
            );
            supermarkets.put(supermarketName.toLowerCase(), supermarket);
        }
    }

    private Supermarket getUserSupermarketChoice(String message) {
        while (true) {
            System.out.println(message);
            System.out.println("Typ one of the following:");

            for (Supermarket superMarket : supermarkets.values()) {
                System.out.printf("- %s%n", superMarket.name);
            }

            String superMarketChoice = scanner.nextLine().toLowerCase();
            Supermarket superMarket = supermarkets.get(superMarketChoice);

            if (superMarket == null) {
                System.out.printf("%s does not exist! Please check your spelling and typ in a valid supermarket name.%n", superMarketChoice);
            } else {
                return superMarket;
            }
        }
    }
}
