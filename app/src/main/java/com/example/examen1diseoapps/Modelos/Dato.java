package com.example.examen1diseoapps.Modelos;

public class Dato {
    private String nombre;
    private String telefono;
    private String web;
    private String informacion;

    public Dato(String nombre, String telefono, String web) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
    }

    public Dato() {
    }

    public Dato(String nombre, String informacion) {
        this.nombre = nombre;
        this.informacion = informacion;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getWeb() {
        return web;
    }
    public String getInformacion() {
        return informacion;
    }

}
