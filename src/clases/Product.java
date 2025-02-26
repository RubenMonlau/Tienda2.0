/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rubenrod
 */
public class Product {
    private int productCode;
    private int modelCode;
    private String size;
    private int storeId;

    public Product(int productCode, int modelCode, String size, int storeId) {
        this.productCode = productCode;
        this.modelCode = modelCode;
        this.size = size;
        this.storeId = storeId;
    }

    // Getters and setters
    public int getProductCode() { return productCode; }
    public int getModelCode() { return modelCode; }
    public String getSize() { return size; }
    public int getStoreId() { return storeId; }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setModelCode(int modelCode) {
        this.modelCode = modelCode;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
