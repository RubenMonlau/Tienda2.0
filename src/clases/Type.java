/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rubenrod
 */
public class Type {
    private String name;
    private String categoryName;

    public Type(String name, String categoryName) {
        this.name = name;
        this.categoryName = categoryName;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getCategoryName() { return categoryName; }
}
