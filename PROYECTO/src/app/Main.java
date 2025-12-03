package app;

import controlador.LoginController;
import modelo.UsuarioDAO;
import vista.FrmLogin;

public class Main {
    public static void main(String[] args) {
        FrmLogin loginView = new FrmLogin();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        LoginController loginController = new LoginController(loginView, usuarioDAO);
        loginView.setVisible(true);
    }
}