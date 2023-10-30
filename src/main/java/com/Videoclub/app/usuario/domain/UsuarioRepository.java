package com.Videoclub.app.usuario.domain;

import java.util.List;

public interface UsuarioRepository {

    public List<Usuario> getAll();

    public void addUser(Usuario usuario);

    public void updateUsers(Integer id, String nombreNuevo);

    public void deleteUser(Integer id);
}
