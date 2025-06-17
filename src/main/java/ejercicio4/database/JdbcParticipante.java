package ejercicio4.database;

import ejercicio4.modelo.Participante;
import ejercicio4.modelo.RegistroParticipante;

import java.sql.*;

public class JdbcParticipante implements RegistroParticipante {

    private Connection dbConn;

    public JdbcParticipante() {
        setupBaseDeDatos();
    }

    private void setupBaseDeDatos() {
        String url = "jdbc:derby:participantes;create=true";

        try {
            this.dbConn = DriverManager.getConnection(url);
            try (Statement st = dbConn.createStatement()) {
                st.executeUpdate("CREATE TABLE participantes (" +
                        "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                        "nombre VARCHAR(255), " +
                        "telefono VARCHAR(20), " +
                        "region VARCHAR(50))");
            } catch (SQLException e) {
                // Código de estado "X0Y32" significa que la tabla ya existe
                if (!"X0Y32".equals(e.getSQLState())) {
                    throw new RuntimeException("Error al crear la tabla", e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo establecer la conexión a la base de datos", e);
        }
    }

    @Override
    public void registrar(Participante participante) {
        try (PreparedStatement st = dbConn.prepareStatement(
                "INSERT INTO participantes(nombre, telefono, region) VALUES (?, ?, ?)")) {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al persistir el participante", e);
        }
    }
}

