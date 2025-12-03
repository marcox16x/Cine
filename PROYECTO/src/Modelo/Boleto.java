package modelo;

public class Boleto {
    private int id;
    private int usuarioId;
    private int funcionId;
    private int cantidad;
    private double total;

    // Constructor para insertar
    public Boleto(int usuarioId, int funcionId, int cantidad, double precioUnitario) {
        this.usuarioId = usuarioId;
        this.funcionId = funcionId;
        this.cantidad = cantidad;
        this.total = cantidad * precioUnitario; // cálculo automático
    }

    // Constructor para listar desde la BD
    public Boleto(int id, int usuarioId, int funcionId, int cantidad, double total) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.funcionId = funcionId;
        this.cantidad = cantidad;
        this.total = total;
    }

    // Getters
    public int getId() { return id; }
    public int getUsuarioId() { return usuarioId; }
    public int getFuncionId() { return funcionId; }
    public int getCantidad() { return cantidad; }
    public double getTotal() { return total; }
}