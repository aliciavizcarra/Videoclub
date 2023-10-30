package com.Videoclub.app.usuario.infrastructure.web;


import com.Videoclub.app.usuario.application.UsuarioUseCases;
import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.infrastructure.data.UsuarioRepositoryMysql;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
