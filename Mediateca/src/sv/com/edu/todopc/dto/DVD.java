/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.edu.todopc.dto;

/**
 *
 * @author Patricia Mejia
 */
public class DVD extends Productos {
    
    private String id;
    private String titulo;
    private String director;
    private String duracion;
    private String genero;
    private String UnidadesDisponibles;
    private String correlativo;

    public DVD() {
    }

    public DVD(String id, String titulo, String director, String duracion, String genero, String UnidadesDisponibles, String correlativo) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.UnidadesDisponibles = UnidadesDisponibles;
        this.correlativo = correlativo;
    }
    
    public DVD(String titulo, String director, String duracion, String genero, String UnidadesDisponibles) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.UnidadesDisponibles = UnidadesDisponibles;
    }

    public DVD(String id, String titulo, String director, String duracion, String genero, String fabricante, String modelo, String microProcesador, String UnidadesDisponibles) {
        super(fabricante, modelo, microProcesador);
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.UnidadesDisponibles = UnidadesDisponibles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUnidadesDisponibles() {
        return UnidadesDisponibles;
    }

    public void setUnidadesDisponibles(String UnidadesDisponibles) {
        this.UnidadesDisponibles = UnidadesDisponibles;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
    
    
}
