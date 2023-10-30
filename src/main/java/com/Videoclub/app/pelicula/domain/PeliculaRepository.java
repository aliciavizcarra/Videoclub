package com.Videoclub.app.pelicula.domain;

import java.util.List;

public interface PeliculaRepository {

    public List<Pelicula> getAll();

    public void addPelicula(Integer id, String nombre, String duracion);

    public void actualizarPelicula();

    public void deletePelicula();



}
