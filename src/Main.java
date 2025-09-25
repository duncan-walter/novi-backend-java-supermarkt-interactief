import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SuperMarket albertHeijn = new SuperMarket(
                new Product("Frikandelbroodje", 0.99f, 10),
                new Product("Kiwi", 2f, 50),
                new Product("0,5-laags toiletpapier", 5f, 100),
                new Product("Cheddar", 2.5f, 10)
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