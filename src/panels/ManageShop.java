/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panels;
import clases.Model;
import clases.Product;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xavierfarmar
 */
public class ManageShop extends javax.swing.JPanel {

      private List<Model> models;  // Lista de modelos  // Lista de productos

    public ManageShop(List<Model> models) {
        this.models = models;
        initComponents();
        initConfig();
        loadModelsToTable();  // Llenar la tabla con los productos

    }
    private void initConfig() {
        // Configurar el color de fondo y el color de la letra
        this.setBackground(new Color(45, 45, 45));  // Fondo gris oscuro
        jLabel1.setForeground(new Color(255, 255, 255));  // Texto blanco claro para el título
        deleteProducts.setBackground(Color.RED); // Botón rojo
        deleteProducts.setForeground(Color.WHITE); // Texto blanco en el botón
        deleteProducts.setFont(new java.awt.Font("Segoe UI", 1, 18)); // Aumentar tamaño de fuente del botón
        
        updateProduct.setBackground(Color.ORANGE); // Botón rojo
        updateProduct.setForeground(Color.WHITE); // Texto blanco en el botón
        updateProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // Aumentar tamaño de fuente del botón
        
        addProduct.setBackground(Color.BLUE); // Botón rojo
        addProduct.setForeground(Color.WHITE); // Texto blanco en el botón
        addProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // Aumentar tamaño de fuente del botón
        
        //Funcionalidad de añadir producto
        // Agregar un ActionListener al botón addProduct
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí llamas a la función que abre el nuevo JFrame (Main Menu)
                addProductsMenu();
            }
        });
        
        // Configurar la tabla
        jTable1.setBackground(Color.BLACK);  // Fondo negro para la tabla
        jTable1.setForeground(Color.WHITE);  // Texto blanco para la tabla
        jTable1.getTableHeader().setBackground(new Color(60, 60, 60));  // Encabezados gris oscuro
        jTable1.getTableHeader().setForeground(Color.WHITE);  // Texto blanco en los encabezados
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16));  // Aumentar tamaño de fuente en la tabla

        // Hacer las filas más anchas
        jTable1.setRowHeight(40);  // Aumentar altura de las filas

        // Configurar bordes
        deleteProducts.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Bordes blancos para el botón
        jTable1.setBorder(BorderFactory.createLineBorder(Color.WHITE));  // Bordes blancos para la tabla

        // Agregar algunas filas de ejemplo
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"AZN-001", "Airforce", "Zapatos", "Sneakers", "Nike", "100"});
        model.addRow(new Object[]{"ASA-001", "Samba", "Zapatos", "Sneakers", "Adidas", "100"});
    }
    
    // Rellenar la tabla con productos
    
    // Función para cargar productos en la tabla
    // Función para cargar modelos en la tabla
    private void loadModelsToTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // Limpiar la tabla antes de agregar los nuevos modelos
        model.setRowCount(0);

        for (Model modelItem : models) {
            // Agregar una fila por cada modelo
            model.addRow(new Object[]{
                modelItem.getCode(),
                modelItem.getName(),
                modelItem.getCategory(),
                modelItem.getType(),
                modelItem.getBrandCode()
            });
        }
    }
    
    
    
     private static void addProductsMenu() {
        JFrame menuFrame = new JFrame("Main Menu");
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(1000, 800);
        menuFrame.setLayout(new FlowLayout());

        // Aquí puedes agregar el panel que quieras mostrar, por ejemplo ManageShop
        JPanel ProductPanel = new AddProductPanel();
        menuFrame.add(ProductPanel);

        menuFrame.setVisible(true);
    }
     
     private static void deleteProductsMenu() {
        JFrame menuFrame = new JFrame("Main Menu");
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(1000, 800);
        menuFrame.setLayout(new FlowLayout());

        // Aquí puedes agregar el panel que quieras mostrar, por ejemplo ManageShop
        JPanel ProductPanel = new AddProductPanel();
        menuFrame.add(ProductPanel);

        menuFrame.setVisible(true);
    }
     
     private static void updateProductMenu() {
        JFrame menuFrame = new JFrame("Main Menu");
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(1000, 800);
        menuFrame.setLayout(new FlowLayout());

        // Aquí puedes agregar el panel que quieras mostrar, por ejemplo ManageShop
        JPanel ProductPanel = new AddProductPanel();
        menuFrame.add(ProductPanel);

        menuFrame.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        deleteProducts = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateProduct = new javax.swing.JButton();
        addProduct = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Tienda");

        deleteProducts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteProducts.setText("Eliminar producto");
        deleteProducts.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Tipo", "Marca", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        updateProduct.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateProduct.setText("Actualizar producto");
        updateProduct.setBorder(null);

        addProduct.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton deleteProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton updateProduct;
    // End of variables declaration//GEN-END:variables
}
