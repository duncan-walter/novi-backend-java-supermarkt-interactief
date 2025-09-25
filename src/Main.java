import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        SuperMarket albertHeijn = new SuperMarket(
                new Product("Frikandelbroodje", 0.99, 10),
                new Product("Kiwi", 2, 50),
                new Product("0,5-laags toiletpapier", 5, 100),
                new Product("Cheddar", 2.5, 10)
        );
        Customer customer = new Customer("Duncan");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which product do you want to buy?");
        String targetProduct = scanner.nextLine();

        System.out.println("How many do you want to buy?");
        int targetQuantity = scanner.nextInt();
        scanner.nextLine(); // Consumeer de overgebleven new-line

        customer.goToSuperMarket(albertHeijn);
        customer.buyItem(targetProduct, targetQuantity);
    }
}