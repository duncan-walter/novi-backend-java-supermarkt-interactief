public class Customer {
    public String name;
    public SuperMarket superMarket;

    public Customer(String name) {
        this.name = name;
    }

    public void goToSuperMarket(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }

    public void buyItem(String productName, int amount) {
        if (superMarket.bread.name.equals(productName)) {
            superMarket.buyBread(amount);
        } else if (superMarket.fruit.name.equals(productName)) {
            superMarket.buyFruit(amount);
        } else if (superMarket.toiletPaper.name.equals(productName)) {
            superMarket.buyToiletPaper(amount);
        } else if (superMarket.cheese.name.equals(productName)) {
            superMarket.buyCheese(amount);
        } else {
            System.out.printf("%s does not exist in this super market.", productName);
        }
    }
}