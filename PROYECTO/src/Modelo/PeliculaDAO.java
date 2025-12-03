package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public boolean insertar(Pelicula p) {
        String sql = "INSERT INTO Peliculas (titulo, genero, duracion, clasificacion, precioEntrada) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getClasificacion());
            ps.setDouble(5, p.getPrecioEntrada());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar película: " + e.getMessage());
            return false;
        }
    }

    public List<Pelicula> listar() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Peliculas";
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pelicula p = new Pelicula(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("genero"),
                    rs.getInt("duracion"),
                    rs.getString("clasificacion"),
                    rs.getDouble("precioEntrada")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar películas: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Pelicula p) {
        String sql = "UPDATE Peliculas SET titulo=?, genero=?, duracion=?, clasificacion=?, precioEntrada=? WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getGenero());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getClasificacion());
            ps.setDouble(5, p.getPrecioEntrada());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar película: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Peliculas WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
            return false;
        }
    }
}