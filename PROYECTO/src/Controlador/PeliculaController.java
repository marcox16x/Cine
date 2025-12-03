package controlador;

import modelo.Pelicula;
import modelo.PeliculaDAO;
import vista.FrmPeliculas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeliculaController implements ActionListener {
    private FrmPeliculas vista;
    private PeliculaDAO dao;

    public PeliculaController(FrmPeliculas vista, PeliculaDAO dao) {
        this.vista = vista;
        this.dao = dao;

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnListar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == vista.btnAgregar) {
            agregar();
        } else if (src == vista.btnListar) {
            listar();
        } else if (src == vista.btnActualizar) {
            actualizar();
        } else if (src == vista.btnEliminar) {
            eliminar();
        }
    }

    private void agregar() {
        try {
            Pelicula p = new Pelicula(
                vista.txtTitulo.getText(),
                vista.txtGenero.getText(),
                Integer.parseInt(vista.txtDuracion.getText()),
                vista.txtClasificacion.getText(),
                Double.parseDouble(vista.txtPrecio.getText())
            );
            if (dao.insertar(p)) {
                vista.mensaje("Película agregada");
            } else {
                vista.mensaje("No se pudo agregar");
            }
            listar();
        } catch (Exception ex) {
            vista.mensaje("Datos inválidos: " + ex.getMessage());
        }
    }

    public void listar() {
        vista.mostrarPeliculas(dao.listar());
    }

    private void actualizar() {
        try {
            Pelicula p = new Pelicula(
                Integer.parseInt(vista.txtId.getText()),
                vista.txtTitulo.getText(),
                vista.txtGenero.getText(),
                Integer.parseInt(vista.txtDuracion.getText()),
                vista.txtClasificacion.getText(),
                Double.parseDouble(vista.txtPrecio.getText())
            );
            if (dao.actualizar(p)) {
                vista.mensaje("Película actualizada");
            } else {
                vista.mensaje("No se pudo actualizar");
            }
            listar();
        } catch (Exception ex) {
            vista.mensaje("Datos inválidos: " + ex.getMessage());
        }
    }

    private void eliminar() {
        try {
            int id = Integer.parseInt(vista.txtId.getText());
            if (dao.eliminar(id)) {
                vista.mensaje("Película eliminada");
            } else {
                vista.mensaje("No se pudo eliminar");
            }
            listar();
        } catch (Exception ex) {
            vista.mensaje("ID inválido: " + ex.getMessage());
        }
    }
}