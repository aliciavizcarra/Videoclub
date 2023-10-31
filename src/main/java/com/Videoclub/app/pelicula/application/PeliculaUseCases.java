package com.Videoclub.app.pelicula.application;

import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.pelicula.domain.PeliculaRepository;

import java.util.List;

public class PeliculaUseCases {

    PeliculaRepository peliculaRepository;


    public PeliculaUseCases(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> getAll(Integer id){
        List<Pelicula> list = this.peliculaRepository.getAll(id);
        return list;
    };

    public void addPelicula(Integer id, Pelicula pelicula){
        this.peliculaRepository.addPelicula(id, pelicula);
    };

    public void actualizarPelicula(String nombre, String nombreViejo){
        this.peliculaRepository.actualizarPelicula(nombre, nombreViejo );
    };

    public void deletePelicula(String nombre){
        this.peliculaRepository.deletePelicula(nombre);
    };
}
