package vista;

import modelo.Usuario;
import controlador.PeliculaController;
import controlador.FuncionController;
import controlador.BoletoController;
import modelo.PeliculaDAO;
import modelo.FuncionDAO;
import modelo.BoletoDAO;

import javax.swing.*;

public class FrmPrincipal extends JFrame {
    private Usuario usuario;
    public JMenuItem miPeliculasGestion, miFuncionesGestion, miBoletosCompra, miCarteleraVer, miFuncionesVer;

    public FrmPrincipal(Usuario usuario) {
        this.usuario = usuario;
        setTitle("CineDB - Menú Principal (" + usuario.getUsername() + " - " + usuario.getRol() + ")");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuPeliculas = new JMenu("Películas");
        JMenu menuFunciones = new JMenu("Funciones");
        JMenu menuBoletos = new JMenu("Boletos");

        miPeliculasGestion = new JMenuItem("Gestionar Películas");
        miFuncionesGestion = new JMenuItem("Gestionar Funciones");
        miBoletosCompra = new JMenuItem("Comprar Boletos");
        miCarteleraVer = new JMenuItem("Ver Cartelera");
        miFuncionesVer = new JMenuItem("Ver Funciones");

        if ("admin".equalsIgnoreCase(usuario.getRol())) {
            menuPeliculas.add(miPeliculasGestion);
            menuFunciones.add(miFuncionesGestion);
        } else {
            menuPeliculas.add(miCarteleraVer);
            menuFunciones.add(miFuncionesVer);
            menuBoletos.add(miBoletosCompra);
        }

        menuBar.add(menuPeliculas);
        menuBar.add(menuFunciones);
        menuBar.add(menuBoletos);
        setJMenuBar(menuBar);

        wireMenuActions();
    }

    private void wireMenuActions() {
        miPeliculasGestion.addActionListener(e -> {
            FrmPeliculas vp = new FrmPeliculas();
            PeliculaController pc = new PeliculaController(vp, new PeliculaDAO());
            vp.setVisible(true);
        });

        miFuncionesGestion.addActionListener(e -> {
            FrmFunciones vf = new FrmFunciones();
            FuncionController fc = new FuncionController(vf, new FuncionDAO());
            fc.listar(); // carga funciones al abrir
            vf.setVisible(true);
        });

        miCarteleraVer.addActionListener(e -> {
            FrmPeliculas vista = new FrmPeliculas();
            PeliculaController controller = new PeliculaController(vista, new PeliculaDAO());
            controller.listar(); // muestra cartelera al abrir
            vista.setVisible(true);
        });

        miFuncionesVer.addActionListener(e -> {
            FrmFunciones vf = new FrmFunciones();
            FuncionController fc = new FuncionController(vf, new FuncionDAO());
            fc.listar(); // muestra funciones al abrir
            vf.setVisible(true);
        });

        miBoletosCompra.addActionListener(e -> {
            FrmVenta vv = new FrmVenta();
            BoletoController bc = new BoletoController(vv, new BoletoDAO());
            bc.mostrarFuncionesDisponibles(); // ← muestra funciones al abrir
            vv.setVisible(true);
        });
    }
}