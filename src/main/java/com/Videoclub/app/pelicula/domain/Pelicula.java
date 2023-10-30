package com.Videoclub.app.pelicula.domain;

public class Pelicula {

    private int id_usuario;

    private String duracion, nombre;


    public Pelicula(String nombre, String duracion, int id_usuario) {
        this.id_usuario = id_usuario;
        this.duracion = duracion;
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id_usuario=" + id_usuario +
                ", duracion='" + duracion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
