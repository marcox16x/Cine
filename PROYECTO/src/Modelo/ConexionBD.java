package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=CineDB;encrypt=false;";
    private static final String USER = "usuario_netbeans"; // ajusta
    private static final String PASS = "12345";            // ajusta

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado a CineDB");
            return conn;
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}