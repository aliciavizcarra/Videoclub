package com.Videoclub.app.usuario.infrastructure.web;


import com.Videoclub.app.usuario.application.UsuarioUseCases;
import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.infrastructure.data.UsuarioRepositoryMysql;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    UsuarioUseCases usuarioUseCases;

    public UsuarioController() {
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioRepositoryMysql());
    }

    @GetMapping("/usuarios")
    public List<Usuario> list(){
        List<Usuario> list = this.usuarioUseCases.getAll();
        return list;
    }

    @PostMapping("/usuarios")
    public List<Usuario> lista( @RequestBody Usuario usuario){
        this.usuarioUseCases.addUser(usuario);
        List<Usuario> list = this.usuarioUseCases.getAll();
        return list;
    }

    @PutMapping("/usuarios/{id}")
    public List<Usuario> usuariosactualizados(@PathVariable Integer id, @RequestBody Usuario usuario){
        this.usuarioUseCases.updateUsers(id, usuario);
        List<Usuario> list = this.usuarioUseCases.getAll();
        return list;
    }

    @DeleteMapping("/usuarios/{id}")
    public List<Usuario> usuarioBorrado(@PathVariable Integer id){
        this.usuarioUseCases.deleteUser(id);
        List<Usuario> list = this.usuarioUseCases.getAll();
        return list;
    }





}
