package com.example.examen1diseoapps.Modelos;

public class Permiso {
    private String nombre;
    private String nombre_real;

    public Permiso(String nombre, String nombre_real) {
        this.nombre = nombre;
        this.nombre_real = nombre_real;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre_real() {
        return nombre_real;
    }
    public void setNombre_real(String nombre_real) {
        this.nombre_real = nombre_real;
    }
}
