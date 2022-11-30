package com.registro.usuarios.modelo;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private double precio;
    private int inventario;


    // constructor


    public Producto() {
    }

    public Producto(int id, String nombre, double precio, int inventario) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    // GETTER & SETTER


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    // TOSTRING


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", inventario=" + inventario +
                '}';
    }
}
