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
    private String servicio;

    private String email;


    // constructor


    public Producto() {
    }

    public Producto(int id, String nombre, double precio, String servicio, String email) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.servicio = servicio;
        this.email = email;
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

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // TOSTRING


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email= "+ email +
                ", precio=" + precio +
                ", inventario=" + servicio +
                '}';
    }
}
