package com.Videoclub.app.pelicula.domain;

import java.util.List;

public interface PeliculaRepository {

    public List<Pelicula> getAll(Integer id);

    public void addPelicula(Integer id, Pelicula pelicula);

    public void actualizarPelicula(String nombreNuevo, String nombreViejo);

    public void deletePelicula(String nombre);

    public void deleteAll();



}
