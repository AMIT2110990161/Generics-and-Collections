package Generics;
// Generic Storage Class
import java.util.ArrayList;
import java.util.List;

// Abstract Class: WarehouseItem.java
abstract class WarehouseItem {
    String name;
    double price;

    WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Subclasses for different item types
class Electronics extends WarehouseItem {
    Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name, double price) {
        super(name, price);
    }
}


class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    void showItems() {
        for (T item : items) {
            System.out.println("Name: " + item.name + ", Price: $" + item.price);
        }
    }
}

// Main Class
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 800));
        electronicsStorage.addItem(new Electronics("Phone", 249));
        groceriesStorage.addItem(new Groceries("Apple", 2));
        groceriesStorage.addItem(new Groceries("Milk", 5));
        furnitureStorage.addItem(new Furniture("Chair", 50));
        furnitureStorage.addItem(new Furniture("Table", 99));

        System.out.println("Electronics:");
        electronicsStorage.showItems();

        System.out.println("\nGroceries:");
        groceriesStorage.showItems();

        System.out.println("\nFurniture:");
        furnitureStorage.showItems();
    }
}
