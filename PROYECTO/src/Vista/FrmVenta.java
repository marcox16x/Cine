package vista;

import javax.swing.*;
import java.awt.*;

public class FrmVenta extends JFrame {
    public JTextField txtUsuarioId, txtFuncionId, txtCantidad, txtPrecio;
    public JButton btnComprar;
    public JTextArea area;

    public FrmVenta() {
        setTitle("Venta de Boletos");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Usuario ID
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Usuario ID:"), gbc);
        gbc.gridx = 1;
        txtUsuarioId = new JTextField();
        txtUsuarioId.setPreferredSize(new Dimension(200, 30));
        form.add(txtUsuarioId, gbc);

        // Función ID
        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Función ID:"), gbc);
        gbc.gridx = 1;
        txtFuncionId = new JTextField();
        txtFuncionId.setPreferredSize(new Dimension(200, 30));
        form.add(txtFuncionId, gbc);

        // Cantidad
        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Cantidad:"), gbc);
        gbc.gridx = 1;
        txtCantidad = new JTextField();
        txtCantidad.setPreferredSize(new Dimension(200, 30));
        form.add(txtCantidad, gbc);

        // Precio unitario
        gbc.gridx = 0; gbc.gridy = 3;
        form.add(new JLabel("Precio unitario (S/):"), gbc);
        gbc.gridx = 1;
        txtPrecio = new JTextField();
        txtPrecio.setPreferredSize(new Dimension(200, 30));
        form.add(txtPrecio, gbc);

        // Botón Comprar
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        btnComprar = new JButton("Comprar");
        form.add(btnComprar, gbc);

        // Área de texto para mostrar funciones disponibles
        area = new JTextArea();
        area.setEditable(false);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
    }

    public void mensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}