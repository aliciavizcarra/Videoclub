package com.Videoclub.app.usuario.domain;

import com.Videoclub.app.pelicula.domain.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private Integer ID; //pasar como null en el constructor

    private String nombre;

    private List<Pelicula> peliculaList;

    public Usuario(Integer ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.peliculaList= new ArrayList<>();
    }

    public void addPelicula(Pelicula pelicula){
        peliculaList.add(pelicula);
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

    public List<Pelicula> getPeliculaList(){
        return peliculaList;
    }

    public void setList(List<Pelicula> list){
        this.peliculaList= list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

}
