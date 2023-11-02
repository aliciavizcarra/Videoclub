package com.Videoclub.app.usuario.application;

import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.domain.UsuarioRepository;

import java.util.List;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll(){
        List<Usuario> list = this.usuarioRepository.getAll();
        return list;
    }

    public void addUser(Usuario usuario){
        this.usuarioRepository.addUser(usuario);
    }

    public void updateUsers(Integer id, Usuario usuario){
        this.usuarioRepository.updateUsers(id,usuario);
    }

    public void deleteUser(Integer id){
        this.usuarioRepository.deleteUser(id);
    }

    public void deleteAll(){
        this.usuarioRepository.deleteAll();
    }
}
