package com.Videoclub.app.pelicula.infrastructure.data;

import com.Videoclub.app.conexionBD.ConexionBD;
import com.Videoclub.app.pelicula.domain.Pelicula;
import com.Videoclub.app.pelicula.domain.PeliculaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaRepositoryMysql implements PeliculaRepository {

    Connection con = ConexionBD.getCon();

    @Override
    public List<Pelicula> getAll(Integer id) {

        List <Pelicula> list = new ArrayList<>();

        String consulta = "SELECT * FROM peliculas WHERE id_usuario=" + id + ";";

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            while (rs.next()){

                String nombre = rs.getString("nombre");
                String duracion = rs.getString("duracion");
                Integer id_usuario = rs.getInt("id_usuario");

                Pelicula pelicula= new Pelicula(nombre,duracion,id_usuario);
                list.add(pelicula);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void addPelicula(Integer id, Pelicula pelicula) {

        String consulta = "INSERT INTO `peliculas`(`nombre`, `duracion`, `id_usuario`) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(consulta)){

            preparedStatement.setString(1,pelicula.getNombre());
            preparedStatement.setString(2,pelicula.getDuracion());
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {

        }

    }

    @Override
    public void actualizarPelicula(String nombreActualizar,String nombreViejo) {

        String consulta = "UPDATE `peliculas` SET `nombre`='" + nombreActualizar + "' WHERE nombre='" + nombreViejo + "';";

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void deletePelicula(String nombre) {

        String consulta = "DElETE FROM peliculas WHERE nombre='" + nombre + "';";

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

