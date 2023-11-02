package com.Videoclub.app.usuario.domain;

import java.util.List;

public interface UsuarioRepository {

    public List<Usuario> getAll();

    public void addUser(Usuario usuario);

    public void updateUsers(Integer id, Usuario usuario);

    public void deleteUser(Integer id);

    public void deleteAll();

    public Usuario getUserFromID();
}
