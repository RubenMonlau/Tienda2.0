/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rubenrod
 */
public class Brand {
    private int brandCode;
    private String name;

    public Brand(int brandCode, String name) {
        this.brandCode = brandCode;
        this.name = name;
    }

    // Getters and setters
    public int getBrandCode() { return brandCode; }
    public String getName() { return name; }
}
