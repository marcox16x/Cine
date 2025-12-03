package modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionDAO {

    public boolean insertar(Funcion f) {
        String sql = "INSERT INTO Funciones (pelicula_id, fecha, hora, sala) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, f.getPeliculaId());
            ps.setDate(2, Date.valueOf(f.getFecha()));
            ps.setTime(3, Time.valueOf(f.getHora()));
            ps.setString(4, f.getSala());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar función: " + e.getMessage());
            return false;
        }
    }

    public List<Funcion> listar() {
        List<Funcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Funciones";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Funcion f = new Funcion(
                    rs.getInt("id"),
                    rs.getInt("pelicula_id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getTime("hora").toLocalTime(),
                    rs.getString("sala")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar funciones: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Funciones WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar función: " + e.getMessage());
            return false;
        }
    }
}