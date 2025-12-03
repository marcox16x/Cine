package vista;

import javax.swing.*;

public class FrmLogin extends JFrame {
    public JTextField txtUsuario;
    public JPasswordField txtPassword;
    public JButton btnLogin, btnRegistro;

    public FrmLogin() {
        setTitle("Login CineDB");
        setSize(320, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 30, 150, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 70, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 70, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(30, 120, 120, 25);
        add(btnLogin);

        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(150, 120, 120, 25);
        add(btnRegistro);
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}