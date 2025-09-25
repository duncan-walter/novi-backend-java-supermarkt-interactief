public class SuperMarket {
    public Product bread;
    public Product fruit;
    public Product toiletPaper;
    public Product cheese;

    public SuperMarket(Product bread, Product fruit, Product toiletPaper, Product cheese) {
        this.bread = bread == null ? getFakeProduct() : bread;
        this.fruit = fruit == null ? getFakeProduct() : fruit;
        this.toiletPaper = toiletPaper == null ? getFakeProduct() : toiletPaper;
        this.cheese = cheese == null ? getFakeProduct() : cheese;
    }

    // In deze methode maak ik gebruik van de printf methode. Dit zorgt ervoor dat ik niet de plus notatie hoef te gebruiken.
    // Daarnaast viel het mij op dat de printf methode in de else van de if-else, twee keer dezelfde waarde print.
    // Na wat zoeken kwam ik er achter dat je de placeholders zo kan definiëren dat dezelfde waarde op verschillende
    // placeholders neergezet kan worden me de juiste syntax. In mijn implementatie krijgen beide %2$s definities dezelfde waarde.
    // De "s" (string), "d" (decimal integer) of "f" (float) duiden het type van de waarde in de placeholder aan.
    private void buyItem(Product product, int amount) {
        if (amount <= product.amount) {
            float totalPrice = amount * product.price;
            System.out.printf("You bought %d %s(s) for %f euro%n", amount, product.name, totalPrice);
            product.amount -= amount;
        } else {
            System.out.printf("You cannot buy %1$d %2$s(s), we only have %3$d %2$s(s) in stock%n", amount, product.name, product.amount);
        }
    }

    public void buyBread(int amount) {
        buyItem(bread, amount);
    }

    public void buyFruit(int amount) {
        buyItem(fruit, amount);
    }

    public void buyToiletPaper(int amount) {
        buyItem(toiletPaper, amount);
    }

    public void buyCheese(int amount) {
        buyItem(cheese, amount);
    }

    private Product getFakeProduct() {
        return new Product("Fake", 0, 0);
    }
}