package Collections;

import java.util.*;

public class ShoppingCart {
    Map<String, Double> productPrices = new HashMap<>();
    Map<String, Double> cartItems = new LinkedHashMap<>();
    TreeMap<Double, String> sortedItems = new TreeMap<>();

    void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    void addToCart(String product) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, productPrices.get(product));
            sortedItems.put(productPrices.get(product), product);
        }
    }

    void displayCart() {
        System.out.println("Cart Items (order added): " + cartItems);
        System.out.println("Cart Items (sorted by price): " + sortedItems);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000.0);
        cart.addProduct("Phone", 700.0);
        cart.addProduct("Tablet", 300.0);

        cart.addToCart("Phone");
        cart.addToCart("Laptop");
        cart.addToCart("Tablet");

        cart.displayCart();
    }
}

