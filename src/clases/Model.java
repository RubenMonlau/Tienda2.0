/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rubenrod
 */
public class Model {
    private int code;
    private String name;
    private String category;
    private String type;
    private int brandCode;

    public Model(int code, String name, String category, String type, int brandCode) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.type = type;
        this.brandCode = brandCode;
    }

    // Getters and setters
    public int getCode() { return code; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getType() { return type; }
    public int getBrandCode() { return brandCode; }
}