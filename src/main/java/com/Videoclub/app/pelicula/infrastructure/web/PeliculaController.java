package com.Videoclub.app.pelicula.infrastructure.web;

import com.Videoclub.app.pelicula.application.PeliculaUseCases;
import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.pelicula.infrastructure.data.PeliculaRepositoryMysql;
import com.Videoclub.app.usuario.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {

    PeliculaUseCases peliculaUseCases;


    public PeliculaController() {
        this.peliculaUseCases = new PeliculaUseCases(new PeliculaRepositoryMysql());


    }

    @GetMapping("/usuario/{id}/peliculas")
    public List<Pelicula> list(@PathVariable Integer id){
        List<Pelicula> list = this.peliculaUseCases.getAll(id);
        return list;
    }

    @PostMapping("/usuario/{id}/peliculas")
    public List<Pelicula> lista(@PathVariable Integer id ,@RequestBody Pelicula pelicula){
        this.peliculaUseCases.addPelicula(id, pelicula);
        List<Pelicula> list = this.peliculaUseCases.getAll(id);
        return list;
    }

    @PutMapping("/usuarios/{id}/pelicula/{nombreActual}")
    public List<Pelicula> usuariosactualizados(@PathVariable Integer id, @PathVariable String nombreActual, String nombreNuevo){
        this.peliculaUseCases.actualizarPelicula(nombreNuevo,nombreActual);
        List<Pelicula> list = this.peliculaUseCases.getAll(id);
        return list;
    }

    @DeleteMapping("/usuarios/{id}/pelicula/{nombre}")
    public List<Pelicula> usuarioBorrado(@PathVariable String nombre, @PathVariable Integer id){
        this.peliculaUseCases.deletePelicula(nombre);
        List<Pelicula> list = this.peliculaUseCases.getAll(id);
        return list;
    }

}
