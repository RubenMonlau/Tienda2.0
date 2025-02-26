/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rubenrod
 */
public class Category {
    private String name;
    private String sizes;

    public Category(String name, String sizes) {
        this.name = name;
        this.sizes = sizes;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getSizes() { return sizes; }
}