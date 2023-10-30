package com.Videoclub.app.usuario.domain;

public class Usuario {

    private Integer ID; //pasar como null en el constructor

    private String nombre;


    public Usuario(Integer ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
