package com.Videoclub.app.usuario.infrastructure.data;

import com.Videoclub.app.conexionBD.ConexionBD;
import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.domain.UsuarioRepository;

import javax.xml.transform.Result;
import java.io.PipedWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsuarioRepositoryMysql implements UsuarioRepository {

    Connection con = ConexionBD.getCon();
    @Override
    public List<Usuario> getAll() {

        HashMap<Usuario,List<Pelicula>> mapaUsuarios = new HashMap<>();
        List<Usuario> list = new ArrayList<>();

        String consulta = "SELECT u.*, p.nombre, p.duracion, p.id_pelicula FROM usuarios u LEFT JOIN peliculas_usuarios pu on u.id_usuario=pu.usuario LEFT JOIN peliculas p on p.id_pelicula=pu.pelicula;";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(consulta);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                Usuario usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("nombreUsuario"));

                Pelicula pelicula = new Pelicula(rs.getString("nombre"), rs.getString("duracion"), rs.getInt("id_pelicula"));

                if(!mapaUsuarios.containsKey(usuario)){
                    List<Pelicula> peliculas = new ArrayList<>();
                    mapaUsuarios.put(usuario,peliculas);
                    usuario.setList(peliculas);
                    list.add(usuario);
                }
                mapaUsuarios.get(usuario).add(pelicula);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void addUser(Usuario usuario) {

        String consulta = "INSERT INTO usuarios(`ID`, `nombre`) VALUES (" + usuario.getID() + ",'" + usuario.getNombre() + "');";

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateUsers(Usuario usuario) {

        String consulta = "UPDATE `usuarios` SET `nombre`='" + usuario.getNombre() + "' WHERE ID=" + usuario.getID() + ";";

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(Integer id) {

        String consulta = "DElETE FROM usuarios WHERE ID=" + id + ";";

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAll() {
        String consulta = "DELETE FROM `usuarios`; ";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
