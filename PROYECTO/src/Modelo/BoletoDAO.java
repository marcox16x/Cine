package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoletoDAO {

    // Método para insertar un boleto en la BD
    public boolean insertar(Boleto b) {
        String sql = "INSERT INTO Boletos (usuario_id, funcion_id, cantidad, total) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, b.getUsuarioId());
            ps.setInt(2, b.getFuncionId());
            ps.setInt(3, b.getCantidad());
            ps.setDouble(4, b.getTotal()); // usamos el total calculado
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar boleto: " + e.getMessage());
            return false;
        }
    }

    // Método para listar todos los boletos
    public List<Boleto> listar() {
        List<Boleto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Boletos";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Boleto b = new Boleto(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getInt("funcion_id"),
                    rs.getInt("cantidad"),
                    rs.getDouble("total")
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar boletos: " + e.getMessage());
        }
        return lista;
    }
}