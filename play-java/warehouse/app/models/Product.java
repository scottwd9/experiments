package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private static List<Product> products;

    static {
        products = new ArrayList<>();

        products.add(new Product("1111111111111", "Paperclips 1",
                "Paperclips description 1"));
        products.add(new Product("2222222222222", "Paperclips 2",
                "Paperclips description 2"));
        products.add(new Product("3333333333333", "Paperclips 3",
                "Paperclips description 3"));
        products.add(new Product("4444444444444", "Paperclips 4",
                "Paperclips description 4"));
        products.add(new Product("5555555555555", "Paperclips 5",
                "Paperclips description 5"));
    }

    public String ean;
    public String name;
    public String description;

    public Product() {
    }

    public Product(String ean, String name, String description) {
        this.ean = ean;
        this.name = name;
        this.description = description;
    }

    public static List<Product> findAll() {
        return products;
    }

    public static boolean remove(Product product) {
        return products.remove(product);
    }

    public static Product findByEan(String ean) {
        List<Product> results = products.stream()
                .filter(product -> product.ean.equals(ean))
                .collect(Collectors.toList());

        if (results.size() == 1) {
            return results.get(0);
        }

        return null;
    }

    public static Product findByName(String name) {
        List<Product> results = products.stream()
                .filter(product -> product.name.toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());

        if (results.size() == 1) {
            return results.get(0);
        }

        return null;
    }

    public void save() {
        products.remove(findByEan(this.ean));
        products.add(this);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", ean, name);
    }
}
