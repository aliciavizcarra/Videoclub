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
    public List<Pelicula> getAll() {

        List <Pelicula> list = new ArrayList<>();

        String consulta = "SELECT * FROM peliculas";

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
    public void addPelicula(Integer id, String nombre, String duracion) {

        String consulta = "INSERT INTO `peliculas`(`nombre`, `duracion`, `id_usuario`) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(consulta)){

            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,duracion);
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {

        }

    }

    @Override
    public void actualizarPelicula() {



    }

    @Override
    public void deletePelicula() {

    }
}
