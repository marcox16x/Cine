package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funcion {
    private int id;
    private int peliculaId;
    private LocalDate fecha;
    private LocalTime hora;
    private String sala;

    public Funcion() {}

    public Funcion(int id, int peliculaId, LocalDate fecha, LocalTime hora, String sala) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }

    public Funcion(int peliculaId, LocalDate fecha, LocalTime hora, String sala) {
        this.peliculaId = peliculaId;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }

    public int getId() { return id; }
    public int getPeliculaId() { return peliculaId; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getSala() { return sala; }

    public void setId(int id) { this.id = id; }
    public void setPeliculaId(int peliculaId) { this.peliculaId = peliculaId; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setSala(String sala) { this.sala = sala; }
}