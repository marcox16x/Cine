package vista;

import modelo.Pelicula;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrmPeliculas extends JFrame {
    public JTextField txtId, txtTitulo, txtGenero, txtDuracion, txtClasificacion, txtPrecio;
    public JButton btnAgregar, btnListar, btnActualizar, btnEliminar;
    public JTextArea area;

    public FrmPeliculas() {
       setTitle("Gestión de Películas");
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
       form.add(new JLabel("ID (para actualizar/eliminar):"), gbc);
       gbc.gridx = 1;
       txtId = new JTextField(); form.add(txtId, gbc);

       // Fila 2: Título
       gbc.gridx = 0; gbc.gridy = 1;
       form.add(new JLabel("Título:"), gbc);
       gbc.gridx = 1;
       txtTitulo = new JTextField(); form.add(txtTitulo, gbc);

       // Fila 3: Género
       gbc.gridx = 0; gbc.gridy = 2;
       form.add(new JLabel("Género:"), gbc);
       gbc.gridx = 1;
       txtGenero = new JTextField(); form.add(txtGenero, gbc);

       // Fila 4: Clasificación
       gbc.gridx = 0; gbc.gridy = 3;
       form.add(new JLabel("Clasificación:"), gbc);
       gbc.gridx = 1;
       txtClasificacion = new JTextField(); form.add(txtClasificacion, gbc);

       // Fila 5: Duración
       gbc.gridx = 0; gbc.gridy = 4;
       form.add(new JLabel("Duración (min):"), gbc);
       gbc.gridx = 1;
       txtDuracion = new JTextField(); form.add(txtDuracion, gbc);

       // Fila 6: Precio Entrada
       gbc.gridx = 0; gbc.gridy = 5;
       form.add(new JLabel("Precio Entrada:"), gbc);
       gbc.gridx = 1;
       txtPrecio = new JTextField(); form.add(txtPrecio, gbc);

       // Fila 7: Botones
       JPanel botones = new JPanel(new FlowLayout());
       btnAgregar = new JButton("Agregar");
       btnListar = new JButton("Listar");
       btnActualizar = new JButton("Actualizar");
       btnEliminar = new JButton("Eliminar");
       botones.add(btnAgregar);
       botones.add(btnListar);
       botones.add(btnActualizar);
       botones.add(btnEliminar);

       gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
       form.add(botones, gbc);

       area = new JTextArea();
       area.setEditable(false);
       add(form, BorderLayout.NORTH);
       add(new JScrollPane(area), BorderLayout.CENTER);
    }

    public void mostrarPeliculas(List<Pelicula> lista) {
        area.setText("");
        for (Pelicula p : lista) {
            area.append(p.getId() + " - " + p.getTitulo() + " | " + p.getGenero() +
                        " | " + p.getDuracion() + "min | " + p.getClasificacion() +
                        " | S/ " + p.getPrecioEntrada() + "\n");
        }
    }

    public void mensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}