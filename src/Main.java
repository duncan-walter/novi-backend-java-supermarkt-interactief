import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> halbertEinProductCatalogue = new ArrayList<>();
        halbertEinProductCatalogue.add(new Product("Frikandelbroodje", 0.99, 10));
        halbertEinProductCatalogue.add(new Product("Kiwi", 2, 50));
        halbertEinProductCatalogue.add(new Product("0,5-laags toiletpapier", 5, 100));
        halbertEinProductCatalogue.add(new Product("Cheddar", 2.5, 10));

        List<Product> dumboProjectCatalogue = new ArrayList<>();
        dumboProjectCatalogue.add(new Product("Melk", 1, 100));
        dumboProjectCatalogue.add(new Product("Banaan", 0.5, 500));
        dumboProjectCatalogue.add(new Product("1-laags toiletpapier", 10, 10));
        dumboProjectCatalogue.add(new Product("Oude kaas", 5, 5));

        List<Product> caldiProjectCatalogue = new ArrayList<>();
        caldiProjectCatalogue.add(new Product("Pepernoten", 2, 100));
        caldiProjectCatalogue.add(new Product("Doperwten", 2, 50));
        caldiProjectCatalogue.add(new Product("2-laags toiletpapier", 10, 100));
        caldiProjectCatalogue.add(new Product("Croissant", 0.25, 100));

        Map<String, SuperMarket> superMarkets = new HashMap<>();
        superMarkets.put("halbert ein", new SuperMarket("Halbert Ein", halbertEinProductCatalogue));
        superMarkets.put("dumbo", new SuperMarket("Dumbo", dumboProjectCatalogue));
        superMarkets.put("caldi", new SuperMarket("Caldi", caldiProjectCatalogue));

        var scanner = new Scanner(System.in);
        var customer = new Customer("Duncan");

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1 - Visit a supermarket");
            System.out.println("2 - Buy a product");
            System.out.println("3 - Restock a product");
            System.out.println("4 - Exit");

            String userMenuChoice = scanner.nextLine();

            switch (userMenuChoice) {
                case "1":
                    System.out.println("Which supermarket would you like to visit?");
                    System.out.println("Typ one of the following:");

                    for (SuperMarket superMarket : superMarkets.values()) {
                        System.out.printf("- %s%n", superMarket.name);
                    }

                    String superMarketChoice = scanner.nextLine().toLowerCase();
                    SuperMarket superMarket = superMarkets.get(superMarketChoice);

                    if (superMarket == null) {
                        System.out.printf("%s does not exist! Please check your spelling and typ in a valid supermarket name.%n", superMarketChoice);
                    } else {
                        customer.goToSuperMarket(superMarket);
                    }

                    break;
                case "2":
                    if (customer.superMarket == null) {
                        System.out.println("Please visit a supermarket first before trying to buy a product!");
                        break;
                    }

                    System.out.printf("What product would you like to buy from %s?%n", customer.superMarket.name);
                    String targetProduct = scanner.nextLine();

                    System.out.printf("How many %s(s) would you like to buy?%n", targetProduct);
                    int targetAmount = scanner.nextInt();
                    scanner.nextLine();

                    customer.buyItem(targetProduct, targetAmount);

                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.printf("%s is not a valid option! Please pick a valid option.%n", userMenuChoice);
                    break;
            }
        }
    }
}