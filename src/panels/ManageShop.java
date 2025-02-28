package panels;

import clases.Brand;
import clases.Category;
import clases.Model;
import clases.Type;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;

public class ManageShop extends javax.swing.JPanel {

    private  List<Model> models;
    private  List<Brand> brands;
    private  List<Category> categories;
    private  Map<Integer, String> brandCodeMap;
    private List<Type> types;



    public ManageShop(List<Model> models, Map<Integer, String> brandCodeMap, List<Category> categories, List<Brand> brands, List<Type> types) {
        this.models = models;
        this.brandCodeMap = brandCodeMap;
        this.categories = categories;
        this.brands = brands;
        this.types = types;
        initComponents();
        initConfig();
        loadModelsToTable();
        initBrandCodeMap();

    }

    private void initBrandCodeMap() {
    brandCodeMap = new HashMap<>();
    for (Brand brand : brands) {
        brandCodeMap.put(brand.getBrandCode(), brand.getName());
    }
}



    private void initConfig() {

        // Agregar MouseListener a la tabla para detectar clics
        jTable1.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint());  // Obtener la fila donde se hizo clic
                if (row >= 0) {  // Verificar si la fila es válida
                    int confirmation = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas eliminar este producto?",
                        "Confirmación de eliminación",
                        JOptionPane.YES_NO_OPTION
                    );
                    // Si el usuario selecciona "Sí"
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // Eliminar el modelo de la lista
                        Model modelToRemove = models.get(row);
                        models.remove(row);
                        // Volver a cargar la tabla después de la eliminación
                        loadModelsToTable();
                        JOptionPane.showMessageDialog(null, "Producto eliminado.");
                    }
                }
            }
        });

        


        // Set a dark, futuristic background
        this.setBackground(new Color(30, 30, 30));  // Dark background
        jLabel1.setForeground(new Color(0, 150, 255));  // Cyan text for the title
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36));  // Modern font

        // Button styling
        Color buttonColor = new Color(0, 150, 255);  // Bright blue for buttons
        Color buttonTextColor = Color.WHITE;  // White text on buttons

        deleteProducts.setBackground(buttonColor);
        deleteProducts.setForeground(buttonTextColor);
        deleteProducts.setFont(new java.awt.Font("Roboto", 1, 14));  // Modern font
        deleteProducts.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));  // Padding

        updateProduct.setBackground(buttonColor);
        updateProduct.setForeground(buttonTextColor);
        updateProduct.setFont(new java.awt.Font("Roboto", 1, 14));
        updateProduct.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        addProduct.setBackground(buttonColor);
        addProduct.setForeground(buttonTextColor);
        addProduct.setFont(new java.awt.Font("Roboto", 1, 14));
        addProduct.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Table styling
        jTable1.setBackground(new Color(40, 40, 40));  // Dark table background
        jTable1.setForeground(Color.WHITE);  // White text
        jTable1.getTableHeader().setBackground(new Color(50, 50, 50));  // Dark header
        jTable1.getTableHeader().setForeground(Color.WHITE);  // White header text
        jTable1.setFont(new java.awt.Font("Roboto", 0, 14));  // Modern font
        jTable1.setRowHeight(30);  // Slightly taller rows
        jTable1.setGridColor(new Color(80, 80, 80));  // Subtle grid lines
        jTable1.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 1)); // Soft border for the table

        // Estilo de las filas alternadas
        jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el fondo de las filas alternadas para mejorar la visibilidad
                if (row % 2 == 0) {
                    cell.setBackground(new Color(60, 60, 60)); // Darker color for even rows
                } else {
                    cell.setBackground(new Color(40, 40, 40)); // Slightly lighter color for odd rows
                }

                // Cambiar el fondo cuando la celda está seleccionada
                if (isSelected) {
                    cell.setBackground(new Color(0, 150, 255)); // Cyan background for selected row
                    cell.setForeground(Color.BLACK); // Black text when selected
                }
                return cell;
            }
        });

        // Add action listeners
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductsMenu();
            }
        });
    }


    private String getBrandNameByCode(int brandCode) {
        return brandCodeMap.getOrDefault(brandCode, "Desconocida");
    }
    

    private void loadModelsToTable() {
        DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
        modelTable.setRowCount(0);  // Limpiar las filas previas

        // Recorrer la lista de modelos y añadirlos a la tabla
        for (Model modelItem : models) {
            String brandName = getBrandNameByCode(modelItem.getBrandCode());  // Obtener el nombre de la marca
            modelTable.addRow(new Object[]{
                modelItem.getCode(),
                modelItem.getName(),
                modelItem.getCategory(),
                modelItem.getType(),
                brandName  // Usar el nombre de la marca en lugar del código
            });
        }
    }


    private void addProductsMenu() {
        // Aquí no creamos una nueva ventana, solo reemplazamos el contenido actual de ManageShop
        AddProductPanel productPanel = new AddProductPanel(models, brandCodeMap, categories, brands, types);
        this.setLayout(new BorderLayout());
        this.add(productPanel, BorderLayout.CENTER);
        this.removeAll();  // Remueve todos los componentes actuales del panel
    
        // Agregar el nuevo panel de productos
        this.add(productPanel);
        
    
        // Vuelve a validar y repintar el panel
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        deleteProducts = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateProduct = new javax.swing.JButton();
        addProduct = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36));
        jLabel1.setText("Tienda Online");

        deleteProducts.setFont(new java.awt.Font("Roboto", 1, 14));
        deleteProducts.setText("Eliminar producto");
        deleteProducts.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String[]{
                "Codigo", "Nombre", "Categoria", "Tipo", "Marca"
            }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        updateProduct.setFont(new java.awt.Font("Roboto", 1, 14));
        updateProduct.setText("Actualizar producto");
        updateProduct.setBorder(null);

        addProduct.setFont(new java.awt.Font("Roboto", 1, 14));
        addProduct.setText("Añadir producto");
        addProduct.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(updateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(deleteProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }

    // Variables declaration
    private javax.swing.JButton addProduct;
    private javax.swing.JButton deleteProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton updateProduct;
}