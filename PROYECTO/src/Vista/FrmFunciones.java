package vista;

import modelo.Funcion;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrmFunciones extends JFrame {
    public JTextField txtId, txtPeliculaId, txtFecha, txtHora, txtSala;
    public JButton btnAgregar, btnListar, btnEliminar;
    public JTextArea area;

    public FrmFunciones() {
        setTitle("Gestión de Funciones");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 1: ID
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("ID (para eliminar):"), gbc);
        gbc.gridx = 1;
        txtId = new JTextField(); form.add(txtId, gbc);

        // Fila 2: Película ID
        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Película ID:"), gbc);
        gbc.gridx = 1;
        txtPeliculaId = new JTextField(); form.add(txtPeliculaId, gbc);

        // Fila 3: Fecha
        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Fecha (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        txtFecha = new JTextField(); form.add(txtFecha, gbc);

        // Fila 4: Hora
        gbc.gridx = 0; gbc.gridy = 3;
        form.add(new JLabel("Hora (HH:MM):"), gbc);
        gbc.gridx = 1;
        txtHora = new JTextField(); form.add(txtHora, gbc);

        // Fila 5: Sala
        gbc.gridx = 0; gbc.gridy = 4;
        form.add(new JLabel("Sala:"), gbc);
        gbc.gridx = 1;
        txtSala = new JTextField(); form.add(txtSala, gbc);

        // Fila 6: Botones
        JPanel botones = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnListar = new JButton("Listar");
        btnEliminar = new JButton("Eliminar");
        botones.add(btnAgregar);
        botones.add(btnListar);
        botones.add(btnEliminar);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        form.add(botones, gbc);

        area = new JTextArea();
        area.setEditable(false);
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
    }

    public void mensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    public void mostrarFunciones(List<Funcion> lista) {
    area.setText("");
    for (Funcion f : lista) {
        area.append("ID: " + f.getId() + " | Película ID: " + f.getPeliculaId() +
                    " | Fecha: " + f.getFecha() + " | Hora: " + f.getHora() +
                    " | Sala: " + f.getSala() + "\n");
    }
}
}