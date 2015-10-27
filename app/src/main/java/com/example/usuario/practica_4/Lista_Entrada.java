package com.example.usuario.practica_4;

public class Lista_Entrada {

    private int iImagen;
    private String nombre;
    private String descripcion;

    public Lista_Entrada(int iImagen, String nombre, String descripcion) {
        this.iImagen = iImagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getiImagen() {
        return iImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
