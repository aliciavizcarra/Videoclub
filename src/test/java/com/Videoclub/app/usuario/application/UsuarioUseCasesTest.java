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

       Usuario usuarioNuevo = new Usuario(null,"Pablo Gonzalez");

       Usuario usuarioActualizado= null;
       this.usuarioUseCases.updateUsers(id,usuario);

       //le asigno al usuario vacio el nombre que espero recibir en el assertEquals
        List<Usuario> list = this.usuarioUseCases.getAll();
        for (Usuario usuario1: list) {
            if (usuario1.getNombre().equals(usuario.getNombre())){
                usuarioActualizado= new Usuario(null,usuario.getNombre());
            }
        }

       assertEquals("Marisa Lopez",usuarioActualizado.getNombre());
    }

    @Test
    void deleteUser() {
        List<Usuario> list = this.usuarioUseCases.getAll();
        this.usuarioUseCases.deleteUser(8);
        assertEquals(6,list.size());
    }
}