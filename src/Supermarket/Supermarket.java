package Supermarket;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    public String name;
    public List<Product> productCatalogue;

    public Supermarket(String name, List<Product> productCatalogue) {
        this.name = name;
        this.productCatalogue = productCatalogue == null ? new ArrayList<>() : productCatalogue;
    }

    // In deze methode maak ik gebruik van de printf methode. Dit zorgt ervoor dat ik niet de plus notatie hoef te gebruiken.
    // Daarnaast viel het mij op dat de printf methode in de else van de if-else, twee keer dezelfde waarde print.
    // Na wat zoeken kwam ik er achter dat je de placeholders zo kan definiëren dat dezelfde waarde op verschillende
    // placeholders neergezet kan worden me de juiste syntax. In mijn implementatie krijgen beide %2$s definities dezelfde waarde.
    // De "s" (string), "d" (decimal integer) of "f" (float) duiden het type van de waarde in de placeholder aan.
    public void buyItem(Product product, int amount) {
        if (amount <= product.amount) {
            double totalPrice = amount * product.price;
            System.out.printf("You bought %d %s(s) for %f euro!%n", amount, product.name, totalPrice);
            product.amount -= amount;
        } else {
            System.out.printf("You cannot buy %1$d %2$s(s), we only have %3$d %2$s(s) in stock%n", amount, product.name, product.amount);
        }
    }

    public void restockItem(String productName, int amount) {
        if (amount < 1) {
            System.out.println("Restock amount must be greater than 0!");
        }

        for (int i = 0; i < productCatalogue.size(); i++) {
            Product product = productCatalogue.get(i);
            if (product.name.equalsIgnoreCase(productName)) {
                product.amount += amount;
                System.out.printf("%d %s(s) were restocked! Current stock: %d%n", amount, product.name, product.amount);
                return;
            }
        }

        System.out.printf("Could not restock %s because it does not exist in the product catalogue of %s.%n", productName, name);
    }
}