package com.Videoclub.app.pelicula.application;

import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.pelicula.infrastructure.data.PeliculaRepositoryMysql;
import com.Videoclub.app.usuario.domain.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeliculaUseCasesTest {

    private PeliculaUseCases peliculaUseCases;

    public PeliculaUseCasesTest() {
        this.peliculaUseCases = new PeliculaUseCases(new PeliculaRepositoryMysql());
    }

    @AfterEach
    void deleteAll(){
        this.peliculaUseCases.deleteAll();
    }

    @Test
    void getAll() {
        List<Pelicula> list = this.peliculaUseCases.getAll(1);
        assertEquals(3,list.size());
    }


    @Test
    void addPelicula() {
        Pelicula pelicula = new Pelicula("Fight Club","02:45:23",1);
        this.peliculaUseCases.addPelicula(1,pelicula);
        List<Pelicula> list = this.peliculaUseCases.getAll(1);
        assertEquals(4,list.size());
    }

    @Test
    void actualizarPelicula() {
        String nombreNuevo = "Fight Club 2";
        String nombreViejo = "Fight Club";
        this.peliculaUseCases.actualizarPelicula(nombreNuevo,nombreViejo);
        List<Pelicula> list = this.peliculaUseCases.getAll(1);
        Pelicula peliculaActualizada= null;
        for (Pelicula pelicula: list) {
            if (pelicula.getNombre().equals(nombreNuevo)){
                peliculaActualizada= new Pelicula(pelicula.getNombre(),pelicula.getDuracion(),pelicula.getId_usuario());
            }
        }

        assertEquals("Fight Club 2",peliculaActualizada.getNombre());
    }

    @Test
    void deletePelicula() {
        List<Pelicula> list = this.peliculaUseCases.getAll(1);
        this.peliculaUseCases.deletePelicula("Fight Club 2");
        assertEquals(3,list.size());
    }
}