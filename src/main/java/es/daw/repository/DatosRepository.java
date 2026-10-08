package es.daw.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.daw.model.Datos;

@Repository
public class DatosRepository {

    private final String url = "jdbc:mysql://localhost:3306/daw";
    private final String usuario = "root";
    private final String password = "tupadre7";

    public List<Datos> obtenerTodos() {

        List<Datos> datos = new ArrayList<>();

        String sql = "SELECT * FROM alumnos";

        try (
                Connection conexion = DriverManager.getConnection(url, usuario, password);
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql)) {

            while (resultado.next()) {

                Datos dato = new Datos(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"));

                datos.add(dato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return datos;
    }
}