package com.Videoclub.app.usuario.application;

import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.infrastructure.data.UsuarioRepositoryMysql;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioUseCasesTest {

    private UsuarioUseCases usuarioUseCases;

    public UsuarioUseCasesTest() {
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioRepositoryMysql());
    }

    @AfterEach
    void deleteAll(){
        this.usuarioUseCases.deleteAll();
    }

    @Test
    void getAll() {
        List<Usuario> list = this.usuarioUseCases.getAll();
        assertEquals(0,list.size());
    }

    @Test
    void addUser() {
        Usuario usuario = new Usuario(null, "Alberto Gomez");
        this.usuarioUseCases.addUser(usuario);
        List<Usuario> list = this.usuarioUseCases.getAll();
        assertEquals(1,list.size());
    }

    @Test
    void updateUsers() {

       Usuario usuario = new Usuario(null,"Marisa Lopez");
       this.usuarioUseCases.addUser(usuario);

       Integer id = this.usuarioUseCases.getIDfromUser(usuario.getNombre());

       Usuario usuarioNuevo = new Usuario(id,"Pablo Gonzalez");

       this.usuarioUseCases.updateUsers(usuarioNuevo);
       //Hasta aqui la actualizacion del usuario, ahora comprobamos si se ha actualizado

        String nombreActualizado= null;

        List<Usuario> list = this.usuarioUseCases.getAll();
        for (Usuario usuario1: list) {
            if (usuario1.getID().equals(usuarioNuevo.getID())){

                nombreActualizado = usuarioNuevo.getNombre();
            }
        }

       assertEquals("Pablo Gonzalez",nombreActualizado);
    }

    @Test
    void deleteUser() {

        Usuario usuario = new Usuario(null,"Marisa Lopez");
        this.usuarioUseCases.addUser(usuario);

        Integer id = this.usuarioUseCases.getIDfromUser(usuario.getNombre());
        this.usuarioUseCases.deleteUser(id);

        List<Usuario> list = this.usuarioUseCases.getAll();

        assertEquals(0,list.size());
    }
}