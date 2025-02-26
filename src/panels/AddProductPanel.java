package panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddProductPanel extends javax.swing.JPanel {

    public AddProductPanel() {
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