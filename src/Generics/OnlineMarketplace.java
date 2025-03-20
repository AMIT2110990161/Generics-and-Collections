package Generics;

import java.util.ArrayList;
import java.util.List;

// Enum for Book Categories
enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY
}

// Enum for Clothing Categories
enum ClothingCategory {
    MENS_WEAR, WOMENS_WEAR, KIDS_WEAR
}

// Enum for Gadget Categories
enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY
}

// Generic Product Class with Bounded Type Parameter
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category=" + category + "}";
    }
}

// Generic method to apply a discount
class DiscountManager {
    public static <T> void applyDiscount(Product<T> product, double percentage) {
        double discountAmount = (product.getPrice() * percentage) / 100;
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied: " + product);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        // Creating a catalog
        List<Product<?>> catalog = new ArrayList<>();

        // Adding products
        Product<BookCategory> book1 = new Product<>("Java Programming", 500, BookCategory.SCIENCE);
        Product<ClothingCategory> cloth1 = new Product<>("Men's T-Shirt", 800, ClothingCategory.MENS_WEAR);
        Product<GadgetCategory> gadget1 = new Product<>("Smartphone", 20000, GadgetCategory.MOBILE);

        catalog.add(book1);
        catalog.add(cloth1);
        catalog.add(gadget1);

        // Displaying catalog
        System.out.println("Initial Catalog:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }

        // Applying discount
        System.out.println("\nApplying Discounts:");
        DiscountManager.applyDiscount(book1, 10);
        DiscountManager.applyDiscount(cloth1, 15);
        DiscountManager.applyDiscount(gadget1, 5);
    }
}

