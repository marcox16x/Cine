package controlador;

import modelo.Boleto;
import modelo.BoletoDAO;
import modelo.Funcion;
import modelo.FuncionDAO;
import vista.FrmVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BoletoController implements ActionListener {
    private FrmVenta vista;
    private BoletoDAO dao;
    private FuncionDAO funcionDAO;

    public BoletoController(FrmVenta vista, BoletoDAO dao) {
        this.vista = vista;
        this.dao = dao;
        this.funcionDAO = new FuncionDAO();

        this.vista.btnComprar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnComprar) {
            comprar();
        }
    }

    private void comprar() {
        try {
            int usuarioId = Integer.parseInt(vista.txtUsuarioId.getText());
            int funcionId = Integer.parseInt(vista.txtFuncionId.getText());
            int cantidad = Integer.parseInt(vista.txtCantidad.getText());
            double precio = Double.parseDouble(vista.txtPrecio.getText());

            Boleto b = new Boleto(usuarioId, funcionId, cantidad, precio);
            if (dao.insertar(b)) {
                vista.mensaje("Compra realizada con éxito");
            } else {
                vista.mensaje("No se pudo registrar la compra");
            }
        } catch (Exception ex) {
            vista.mensaje("Datos inválidos: " + ex.getMessage());
        }
    }

    public void mostrarFuncionesDisponibles() {
        List<Funcion> lista = funcionDAO.listar();
        vista.area.setText("Funciones disponibles:\n");
        for (Funcion f : lista) {
            vista.area.append("ID: " + f.getId() +
                              " | Película ID: " + f.getPeliculaId() +
                              " | Fecha: " + f.getFecha() +
                              " | Hora: " + f.getHora() +
                              " | Sala: " + f.getSala() + "\n");
        }
    }
}