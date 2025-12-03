package controlador;

import modelo.Funcion;
import modelo.FuncionDAO;
import vista.FrmFunciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionController implements ActionListener {
    private FrmFunciones vista;
    private FuncionDAO dao;

    public FuncionController(FrmFunciones vista, FuncionDAO dao) {
        this.vista = vista;
        this.dao = dao;

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnListar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == vista.btnAgregar) {
            agregar();
        } else if (src == vista.btnListar) {
            listar();
        } else if (src == vista.btnEliminar) {
            eliminar();
        }
    }

    public void listar() {
        vista.mostrarFunciones(dao.listar());
    }

    private void agregar() {
        try {
            Funcion f = new Funcion(
                Integer.parseInt(vista.txtPeliculaId.getText()),
                java.time.LocalDate.parse(vista.txtFecha.getText()),
                java.time.LocalTime.parse(vista.txtHora.getText() + ":00"),
                vista.txtSala.getText()
            );
            if (dao.insertar(f)) {
                vista.mensaje("Función agregada");
            } else {
                vista.mensaje("No se pudo agregar");
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
                vista.mensaje("Función eliminada");
            } else {
                vista.mensaje("No se pudo eliminar");
            }
            listar();
        } catch (Exception ex) {
            vista.mensaje("ID inválido: " + ex.getMessage());
        }
    }
}