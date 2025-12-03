package modelo;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int duracion;
    private String clasificacion;
    private double precioEntrada;

    public Pelicula() {}

    public Pelicula(int id, String titulo, String genero, int duracion, String clasificacion, double precioEntrada) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.precioEntrada = precioEntrada;
    }

    public Pelicula(String titulo, String genero, int duracion, String clasificacion, double precioEntrada) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.precioEntrada = precioEntrada;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }
    public String getClasificacion() { return clasificacion; }
    public double getPrecioEntrada() { return precioEntrada; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    public void setPrecioEntrada(double precioEntrada) { this.precioEntrada = precioEntrada; }
}