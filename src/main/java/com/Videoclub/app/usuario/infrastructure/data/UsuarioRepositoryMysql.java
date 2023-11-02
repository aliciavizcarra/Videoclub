package com.Videoclub.app.usuario.infrastructure.data;

import com.Videoclub.app.conexionBD.ConexionBD;
import com.Videoclub.app.usuario.domain.Usuario;
import com.Videoclub.app.usuario.domain.UsuarioRepository;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryMysql implements UsuarioRepository {

    Connection con = ConexionBD.getCon();
    @Override
    public List<Usuario> getAll() {

        List<Usuario> list = new ArrayList<>();

        String consulta = "SELECT * FROM usuarios";

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            while (rs.next()){
                String nombre = rs.getString("nombre");
                Integer id = rs.getInt("ID");

                list.add(new Usuario(id,nombre) );
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
