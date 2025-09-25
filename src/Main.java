import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
        superMarkets.put("caldi", new SuperMarket("Caldi", caldiProjectCatalogue));;
    }
}