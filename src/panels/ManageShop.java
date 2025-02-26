package panels;

import clases.Model;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ManageShop extends javax.swing.JPanel {

    private List<Model> models;

    public ManageShop(List<Model> models) {
        this.models = models;
        initComponents();
        initConfig();
        loadModelsToTable();
    }

    private void initConfig() {
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
        jTable1.setBorder(BorderFactory.createEmptyBorder());  // Remove border

        // Add action listeners
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductsMenu();
            }
        });
    }

    private void loadModelsToTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Model modelItem : models) {
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

        JPanel ProductPanel = new AddProductPanel();
        menuFrame.add(ProductPanel);

        menuFrame.setVisible(true);
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
        jLabel1.setText("Tienda");

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