/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rubenrod
 */
public class Store {
    private int id;
    private String name;
    private String direction;
    private String telefono;

    public Store(int id, String name, String direction, String telefono) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.telefono = telefono;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDirection() { return direction; }
    public String getTelefono() { return telefono; }
}
