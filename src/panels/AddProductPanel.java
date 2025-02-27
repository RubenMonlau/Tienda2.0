package panels;

import java.util.List;
import java.util.Map;

import clases.Model;
import clases.Brand;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import application.ClothingStoreManager;

import java.util.ArrayList;

import clases.Category;
public class AddProductPanel extends javax.swing.JPanel {

    private List<Model> models;
    private List<Category> categories;
    private List<Brand> brands;
    private Map<Integer, String> brandCodeMap;

    public AddProductPanel(List<Model> models, Map<Integer, String> brandCodeMap, List<Category> categories, List<Brand> brands) {
        this.models = models;
        this.brandCodeMap = brandCodeMap;
        this.categories = categories;
        this.brands = brands; 
        
        initComponents();
        initConfig();

        
    }
    

    private void initConfig() {
        // Configuración del fondo y fuente general
        this.setBackground(new Color(30, 30, 30)); // Fondo oscuro

        // Configuración del título
        jLabel1.setForeground(new Color(0, 150, 255)); // Texto cian
        jLabel1.setFont(new Font("Roboto", Font.BOLD, 36)); // Fuente moderna

        // Configuración de las etiquetas
        Color labelColor = new Color(200, 200, 200); // Texto gris claro
        Font labelFont = new Font("Roboto", Font.BOLD, 18); // Fuente moderna

        jLabel3.setForeground(labelColor);
        jLabel3.setFont(labelFont);

        jLabel4.setForeground(labelColor);
        jLabel4.setFont(labelFont);

        jLabel5.setForeground(labelColor);
        jLabel5.setFont(labelFont);

        jLabel6.setForeground(labelColor);
        jLabel6.setFont(labelFont);
        

        // Configuración de los campos de texto y combobox
        Color fieldBackground = new Color(40, 40, 40); // Fondo oscuro para campos
        Color fieldForeground = Color.WHITE; // Texto blanco
        Font fieldFont = new Font("Roboto", Font.PLAIN, 16); // Fuente moderna

        jTextField1.setBackground(fieldBackground);
        jTextField1.setForeground(fieldForeground);
        jTextField1.setFont(fieldFont);
        jTextField1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding

        CategorieCombo.setBackground(fieldBackground);
        CategorieCombo.setForeground(fieldForeground);
        CategorieCombo.setFont(fieldFont);
        CategorieCombo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        TipeCombo.setBackground(fieldBackground);
        TipeCombo.setForeground(fieldForeground);
        TipeCombo.setFont(fieldFont);
        TipeCombo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        MarcaCombo.setBackground(fieldBackground);
        MarcaCombo.setForeground(fieldForeground);
        MarcaCombo.setFont(fieldFont);
        MarcaCombo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configuración del botón
        Color buttonColor = new Color(0, 150, 255); // Azul brillante
        Color buttonTextColor = Color.WHITE; // Texto blanco

        AddProduct.setBackground(buttonColor);
        AddProduct.setForeground(buttonTextColor);
        AddProduct.setFont(new Font("Roboto", Font.BOLD, 18)); // Fuente moderna
        AddProduct.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
        
        
        

        // Llenar el ComboBox con los nombres de las categorías
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Category category : categories) {
            model.addElement(category.getName()); // Añadir solo el nombre de la categoría
        }
        CategorieCombo.setModel(model);

        // Añadimos el listener al botón
        AddProduct.addActionListener(e -> addProductAction());

        // Llenar el ComboBox de marcas
        DefaultComboBoxModel<String> brandModel = new DefaultComboBoxModel<>();
        if (brands != null && !brands.isEmpty()) {
            for (Brand brand : brands) {
                brandModel.addElement(brand.getName()); // Añadir el nombre de la marca
            }
        } else {
            brandModel.addElement("No hay marcas disponibles");
        }
        MarcaCombo.setModel(brandModel);
        
    }

    private void addProductAction() {
        // Obtener datos del formulario
        String name = jTextField1.getText();
        String category = (String) CategorieCombo.getSelectedItem();
        String type = (String) TipeCombo.getSelectedItem();
        String brandName = (String) MarcaCombo.getSelectedItem();
        
        // Validación básica para asegurarse de que no estén vacíos
        if (name.isEmpty() || category.isEmpty() || brandName.isEmpty()) {
            System.out.println("Por favor, complete todos los campos.");
            return;
        }
    
        // Generar el código del modelo con las iniciales
        String modelCode = getModelCode(name, category, brandName);
        
        // Buscar el objeto Category correspondiente al nombre seleccionado
        Category selectedCategory = null;
        for (Category cat : categories) {
            if (cat.getName().equals(category)) {
                selectedCategory = cat;
                break;
            }
        }
        
        // Buscar la marca seleccionada en la lista de marcas
        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equals(brandName)) {
                selectedBrand = brand;
                break;
            }
        }
        
        // Verificar si se ha encontrado la marca
        if (selectedBrand == null) {
            System.out.println("Marca no encontrada: " + brandName);
            return;
        }
    
        // Obtener el código de la marca
        int brandCode = selectedBrand.getBrandCode();
    
        // Crear un nuevo modelo y agregarlo a la lista
        Model newModel = new Model(modelCode, name, selectedCategory.getName(), type, brandCode);
        models.add(newModel);
    
        // Confirmar que el producto fue añadido
        System.out.println("Producto añadido: " + newModel.getName() + " con código de modelo: " + modelCode);

        // Cerrar el panel de añadir producto y mostrar el menú principal nuevamente
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this); // Obtener el JFrame contenedor
        if (parentFrame != null) {
        parentFrame.setVisible(false); // Cerrar el panel actual
        }

    // Volver al menú principal
        ClothingStoreManager.showMenuAgain(); // Mostrar nuevamente el menú principal
    }

    private String getModelCode(String name, String category, String brand) {
        // Obtener las primeras letras de cada campo (nombre, categoría, marca)
        String nameInitial = name.isEmpty() ? "" : name.substring(0, 1).toUpperCase();  // Primer letra del nombre del producto
        String categoryInitial = category.isEmpty() ? "" : category.substring(0, 1).toUpperCase();  // Primer letra de la categoría
        String brandInitial = brand.isEmpty() ? "" : brand.substring(0, 1).toUpperCase();  // Primer letra de la marca
    
        // Concatenar las iniciales para formar el código del modelo
        return nameInitial + categoryInitial + brandInitial;
    }
    
    
    

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        CategorieCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TipeCombo = new javax.swing.JComboBox<>();
        MarcaCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AddProduct = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36));
        jLabel1.setText("Añadir producto");

        jTextField1.setText("Nombre del producto");

        CategorieCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoría 1", "Categoría 2", "Categoría 3", "Categoría 4" }));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18));
        jLabel3.setText("Marca");

        TipeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo 1", "Tipo 2", "Tipo 3", "Tipo 4" }));

        MarcaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca 1", "Marca 2", "Marca 3", "Marca 4" }));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18));
        jLabel4.setText("Categoría");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18));
        jLabel5.setText("Tipo");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18));
        jLabel6.setText("Nombre");

        AddProduct.setText("Añadir producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MarcaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CategorieCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(267, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategorieCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MarcaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
    }

    // Variables declaration
    private javax.swing.JButton AddProduct;
    private javax.swing.JComboBox<String> CategorieCombo;
    private javax.swing.JComboBox<String> MarcaCombo;
    private javax.swing.JComboBox<String> TipeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
}