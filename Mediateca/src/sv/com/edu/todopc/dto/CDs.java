/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.edu.todopc.dto;

/**
 *
 * @author Patricia Mejia
 */
public class CDs extends Productos {
    
    private String id;
    private String titulo;
    private String autor;
    private String idioma;
    private String detalles;
    private String edicion;
    private String temas;
    private String CDD;
    private String uniDisponibles;
    private String correlativo;

    public CDs() {
    }

    public CDs(String id, String titulo, String autor, String idioma, String detalles, String edicion, String temas, String CDD, String uniDisponibles,String correlativo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.detalles = detalles;
        this.edicion = edicion;
        this.temas = temas;
        this.CDD = CDD;
        this.uniDisponibles = uniDisponibles;
        this.correlativo = correlativo;

    }
    
     public CDs(String titulo, String autor, String idioma, String detalles, String edicion, String temas, String CDD, String uniDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.detalles = detalles;
        this.edicion = edicion;
        this.temas = temas;
        this.CDD = CDD;
        this.uniDisponibles = uniDisponibles;
    }
    
    

    public CDs(String id, String titulo, String autor, String idioma, String detalles, String edicion, String temas, String CDD, String uniDisponibles, String fabricante, String modelo, String microProcesador) {
        super(fabricante, modelo, microProcesador);
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.detalles = detalles;
        this.edicion = edicion;
        this.uniDisponibles = uniDisponibles;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getUniDisponibles() {
        return uniDisponibles;
    }

    public void setUniDisponibles(String uniDisponibles) {
        this.uniDisponibles = uniDisponibles;
    }
    
     public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }
    
    public String getCDD() {
        return CDD;
    }

    public void setCDD(String CDD) {
        this.CDD = CDD;
    }
}
