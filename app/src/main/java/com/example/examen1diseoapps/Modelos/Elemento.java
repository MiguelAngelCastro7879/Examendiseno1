package com.example.examen1diseoapps.Modelos;

import android.content.Intent;

public class Elemento {
    private int imagen;
    private String Nombre;
    private String dato;
    private Intent intent;

    public Elemento(int imagen, String nombre,Intent intent) {
        this.imagen = imagen;
        this.Nombre = nombre;
        this.intent=intent;
    }

    public Intent getIntent() {
        return intent;
    }
    public void setIntent(Intent intent) {
        this.intent = intent;
    }
    public int getImagen() {
        return imagen;
    }
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDato() {
        return dato;
    }
    public void setDato(String dato) {
        this.dato = dato;
    }

}
