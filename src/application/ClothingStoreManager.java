package application;

import clases.*;
import javax.swing.*;
import java.util.ArrayList;
import exceptions.*;
import java.awt.HeadlessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClothingStoreManager {
    private static List<Store> stores = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Model> models = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<Type> types = new ArrayList<>();
    private static List<Brand> brands = new ArrayList<>();

    private static Store loggedInStore = null; // Track the logged-in store

    public static void main(String[] args) {
        // Initialize example data
        initializeData();

        // Login
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Clothing Store Manager Login ---");
        System.out.print("Enter Store Name: ");
        String storeName = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        loggedInStore = login(storeName, phoneNumber);
        if (loggedInStore == null) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        System.out.println("Login successful! Welcome, " + loggedInStore.getName() + ".");

        // Display menu
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View Products in My Store");
            System.out.println("2. Add Product to My Store");
            System.out.println("3. Update Product in My Store");
            System.out.println("4. Delete Product from My Store");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    viewProductsInStore(loggedInStore.getId());
                    break;
                case 2:
                    addProductToStore(scanner, loggedInStore.getId());
                    break;
                case 3:
                    updateProduct(scanner, loggedInStore.getId());
                    break;
                case 4:
                    deleteProduct(scanner, loggedInStore.getId());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void initializeData() {
        // Add example stores
        stores.add(new Store(1, "Store A", "123 Main St", "555-1234"));
        stores.add(new Store(2, "Store B", "456 Elm St", "555-5678"));

        // Add example brands
        brands.add(new Brand(1, "Nike"));
        brands.add(new Brand(2, "Adidas"));

        // Add example categories
        categories.add(new Category("Shoe", "8,9,10"));
        categories.add(new Category("Hoodie", "S,M,L"));

        // Add example types
        types.add(new Type("Sport", "Shoe"));
        types.add(new Type("Oversized", "Hoodie"));

        // Add example models
        models.add(new Model(1, "Air Max", "Shoe", "Sport", 1));
        models.add(new Model(2, "Classic Hoodie", "Hoodie", "Oversized", 2));
    }

    private static Store login(String storeName, String phoneNumber) {
        for (Store store : stores) {
            if (store.getName().equalsIgnoreCase(storeName) && store.getTelefono().equals(phoneNumber)) {
                return store; // Return the store if credentials match
            }
        }
        return null; // Return null if no match is found
    }

    private static void viewProductsInStore(int storeId) {
        System.out.println("\n--- Products in Store " + storeId + " ---");
        boolean found = false;
        for (Product product : products) {
            if (product.getStoreId() == storeId) {
                System.out.println("Product Code: " + product.getProductCode() +
                        ", Model Code: " + product.getModelCode() +
                        ", Size: " + product.getSize());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found in this store.");
        }
    }

    private static void addProductToStore(Scanner scanner, int storeId) {
        System.out.print("Enter Model Code: ");
        int modelCode = getIntInput(scanner, "Enter Model Code: ");
        Model model = findModelByCode(modelCode);

        if (model == null) {
            System.out.println("Model not found.");
            return;
        }

        // Get the category of the model
        Category category = findCategoryByName(model.getCategory());
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }

        // Validate size based on category
        System.out.print("Enter Size: ");
        String size = scanner.next();
        if (!isValidSizeForCategory(size, category)) {
            System.out.println("Invalid size for category. Allowed sizes: " + category.getSizes());
            return;
        }

        // Add new product
        int newProductCode = products.size() + 1;
        products.add(new Product(newProductCode, modelCode, size, storeId));
        System.out.println("Product added successfully!");
    }

    private static void updateProduct(Scanner scanner, int storeId) {
        System.out.print("Enter Product Code to update: ");
        int productCode = getIntInput(scanner, "Enter Product Code to update: ");
        Product product = findProductByCodeAndStore(productCode, storeId);

        if (product == null) {
            System.out.println("Product not found in your store.");
            return;
        }

        // Get the model and category
        Model model = findModelByCode(product.getModelCode());
        if (model == null) {
            System.out.println("Model not found.");
            return;
        }

        Category category = findCategoryByName(model.getCategory());
        if (category == null) {
            System.out.println("Category not found.");
            return;
        }

        // Validate new size
        System.out.print("Enter new Size (current: " + product.getSize() + "): ");
        String newSize = scanner.next();
        if (!isValidSizeForCategory(newSize, category)) {
            System.out.println("Invalid size for category. Allowed sizes: " + category.getSizes());
            return;
        }

        // Update product
        product.setSize(newSize);
        System.out.println("Product updated successfully!");
    }

    private static void deleteProduct(Scanner scanner, int storeId) {
        System.out.print("Enter Product Code to delete: ");
        int productCode = getIntInput(scanner, "Enter Product Code to delete: ");
        Product product = findProductByCodeAndStore(productCode, storeId);

        if (product == null) {
            System.out.println("Product not found in your store.");
            return;
        }

        products.remove(product);
        System.out.println("Product deleted successfully!");
    }

    private static Product findProductByCodeAndStore(int productCode, int storeId) {
        for (Product product : products) {
            if (product.getProductCode() == productCode && product.getStoreId() == storeId) {
                return product;
            }
        }
        return null;
    }

    private static Model findModelByCode(int modelCode) {
        for (Model model : models) {
            if (model.getCode() == modelCode) {
                return model;
            }
        }
        return null;
    }

    private static Category findCategoryByName(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        return null;
    }

    private static boolean isValidSizeForCategory(String size, Category category) {
        String[] allowedSizes = category.getSizes().split(",");
        for (String allowedSize : allowedSizes) {
            if (allowedSize.trim().equalsIgnoreCase(size)) {
                return true;
            }
        }
        return false;
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}