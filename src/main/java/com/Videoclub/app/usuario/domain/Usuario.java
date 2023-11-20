package com.Videoclub.app.usuario.domain;

import com.Videoclub.app.pelicula.domain.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Integer ID; //pasar como null en el constructor

    private String nombre;


    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    private List<Pelicula> peliculaList;

    public Usuario(Integer ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.peliculaList= new ArrayList<>();
    }

    public Integer getID() {
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
