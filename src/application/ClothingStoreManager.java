package application;

import clases.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import panels.ManageShop;


public class ClothingStoreManager {
    private static List<Store> stores = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Model> models = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<Type> types = new ArrayList<>();
    private static List<Brand> brands = new ArrayList<>();
    private static Product newProduct;
    private static Product updatedProduct;
    private static Map<Integer, String> brandCodeMap;
    private static JFrame menuFrame;


    public static void main(String[] args) {
        // Initialize data
        initializeData();
        // Show main menu after initializing data
        showMainMenu();
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
        models.add(new Model("ASN", "Air Max", "Shoe", "Sport", 1));
        models.add(new Model("CHA", "Classic Hoodie", "Hoodie", "Oversized", 2));
        models.add(new Model("ASN", "Air Force", "Shoe", "Sneakers", 1));
    
        // Initialize brandCodeMap here
        brandCodeMap = new HashMap<>();
            for (Brand brand : brands) {
            brandCodeMap.put(brand.getBrandCode(), brand.getName());
    }

    }

    private static void showMainMenu() {
        menuFrame = new JFrame("Main Menu");
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 600);
        menuFrame.setLayout(new BorderLayout());
          
        
        JPanel ManagePanel = new ManageShop(models, brandCodeMap, categories, brands);
 
        menuFrame.add(ManagePanel);

        menuFrame.setVisible(true);
        
    }
    
    // Método para cerrar el frame y mostrar nuevamente el menú principal
    public static void showMenuAgain() {
        // Si el menuFrame ya existe, lo volvemos a mostrar
        if (menuFrame != null) {
             menuFrame.dispose(); // Esto cierra el JFrame actual
         // Crear el nuevo JFrame
        menuFrame = new JFrame("Main Menu");
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(800, 600);
        menuFrame.setLayout(new BorderLayout());

        // Crear tu panel de gestión y añadirlo al JFrame
        JPanel managePanel = new ManageShop(models, brandCodeMap, categories, brands);
        menuFrame.add(managePanel);

        // Hacer visible el frame
        menuFrame.setVisible(true);
        }
    }

    public static void addProductToStore(Product newProduct) {
        // Add product logic (can use input dialog or another JFrame to get product details)
        JOptionPane.showMessageDialog(null, "Add Product functionality coming soon!");
    }

    public static void updateProduct(Product updatedProduct) {
        // Update product logic (can use input dialog or another JFrame to get product details)
        JOptionPane.showMessageDialog(null, "Update Product functionality coming soon!");
    }

    public static void deleteProduct(int productCode, int storeId) {
        // Delete product logic (can use input dialog or another JFrame to get product details)
        JOptionPane.showMessageDialog(null, "Delete Product functionality coming soon!");
    }

    public static List<Product> getProductsForStore(int storeId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
