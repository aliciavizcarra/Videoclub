package com.Videoclub.app.pelicula.application;

import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.pelicula.infrastructure.data.PeliculaRepositoryMysql;
import com.Videoclub.app.usuario.application.UsuarioUseCases;
import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.infrastructure.data.UsuarioRepositoryMysql;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeliculaUseCasesTest {

    private PeliculaUseCases peliculaUseCases;
    private UsuarioUseCases usuarioUseCases;

    public PeliculaUseCasesTest() {
        this.peliculaUseCases = new PeliculaUseCases(new PeliculaRepositoryMysql());
        this.usuarioUseCases= new UsuarioUseCases(new UsuarioRepositoryMysql());
    }

    @AfterEach
    void deleteAllPeliculas(){
        this.peliculaUseCases.deleteAll();
    }

    @AfterEach
    void deleteAllUsuarios(){this.usuarioUseCases.deleteAll();}

    @Test
    void getAll() {
        List<Pelicula> list = this.peliculaUseCases.getAll(1);
        assertEquals(0,list.size());
    }


    @Test
    void addPelicula() {

        Usuario usuario = new Usuario(null,"Alvaro Martinez");
        this.usuarioUseCases.addUser(usuario);

        Integer id = this.usuarioUseCases.getIDfromUser("Alvaro Martinez");
        Pelicula pelicula = new Pelicula("Fight Club","02:45:23",id);

        this.peliculaUseCases.addPelicula(id,pelicula);
        List<Pelicula> list = this.peliculaUseCases.getAll(id);
        assertEquals(1,list.size());
    }

    @Test
    void actualizarPelicula() {
        Usuario usuario = new Usuario(null,"Alvaro Martinez");
        this.usuarioUseCases.addUser(usuario);

        Integer id = this.usuarioUseCases.getIDfromUser("Alvaro Martinez");
        Pelicula peliculaVieja = new Pelicula("Fight Club", "02:45:02",id);
        this.peliculaUseCases.addPelicula(id,peliculaVieja);

        String nombreNuevo = "Fight Club 2";

        this.peliculaUseCases.actualizarPelicula(nombreNuevo,peliculaVieja.getNombre());
        List<Pelicula> list = this.peliculaUseCases.getAll(id);
        String nombreActualizado=null;


        for (Pelicula pelicula: list) {
            if (pelicula.getNombre().equals(nombreNuevo)){
               nombreActualizado=nombreNuevo;
            }
        }

        assertEquals("Fight Club 2",nombreActualizado);
    }

    @Test
    void deletePelicula() {
        Usuario usuario = new Usuario(null,"Alvaro Martinez");
        this.usuarioUseCases.addUser(usuario);

        Integer id = this.usuarioUseCases.getIDfromUser("Alvaro Martinez");
        Pelicula pelicula = new Pelicula("Fight Club", "02:45:02",id);
        this.peliculaUseCases.addPelicula(id,pelicula);

        this.peliculaUseCases.deletePelicula("Fight Club");
        List<Pelicula> list = this.peliculaUseCases.getAll(id);

        assertEquals(0,list.size());
    }
}