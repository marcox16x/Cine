package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private FrmLogin vista;
    private UsuarioDAO dao;

    public LoginController(FrmLogin vista, UsuarioDAO dao) {
        this.vista = vista;
        this.dao = dao;
        this.vista.btnLogin.addActionListener(this);
        this.vista.btnRegistro.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == vista.btnLogin) {
            login();
        } else if (src == vista.btnRegistro) {
            registrar();
        }
    }

    private void login() {
        String user = vista.txtUsuario.getText().trim();
        String pass = new String(vista.txtPassword.getPassword());
        Usuario u = dao.login(user, pass);
        if (u != null) {
            vista.mostrarMensaje("Bienvenido " + u.getUsername());
            vista.dispose();
            FrmPrincipal principal = new FrmPrincipal(u);
            principal.setVisible(true);
        } else {
            vista.mostrarMensaje("Usuario o contraseña incorrectos");
        }
    }

    private void registrar() {
        String user = vista.txtUsuario.getText().trim();
        String pass = new String(vista.txtPassword.getPassword());
        if (user.isEmpty() || pass.isEmpty()) {
            vista.mostrarMensaje("Ingresa usuario y contraseña");
            return;
        }
        Usuario nuevo = new Usuario(user, pass, "usuario");
        if (dao.registrar(nuevo)) {
            vista.mostrarMensaje("Usuario registrado");
        } else {
            vista.mostrarMensaje("No se pudo registrar");
        }
    }
}