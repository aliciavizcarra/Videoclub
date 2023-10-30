package com.Videoclub.app.pelicula.application;

import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.pelicula.domain.PeliculaRepository;

import java.util.List;

public class PeliculaUseCases {

    PeliculaRepository peliculaRepository;


    public PeliculaUseCases(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> getAll(){
        List<Pelicula> list = this.peliculaRepository.getAll();
        return list;
    };

    public void addPelicula(Integer id, String nombre, String duracion){
        this.peliculaRepository.addPelicula(id, nombre,duracion);
    };

    public void actualizarPelicula(){
        this.peliculaRepository.actualizarPelicula();
    };

    public void deletePelicula(){
        this.peliculaRepository.deletePelicula();
    };
}
