/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.edu.todopc.dto;

import java.sql.Date;



/**
 *
 * @author Patricia Mejia
 */
public class Revistas extends Productos {
    
    private Long id;
    private String titulo;
    private String editorial;
    private String periodicidad;
    private Date fechaPub;
    private String unidDisponibles;
    private String correlativo;

    public Revistas() {
    }

    public Revistas(Long id, String titulo, String editorial, String periodicidad, Date fechaPub, String unidDisponibles, String correlativo) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPub = fechaPub;
        this.unidDisponibles = unidDisponibles;
        this.correlativo = correlativo;
    }
    
    public Revistas(String titulo, String editorial, String periodicidad, Date fechaPub, String unidDisponibles) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPub = fechaPub;
        this.unidDisponibles = unidDisponibles;
    }

    public Revistas(Long id, String titulo, String editorial, String periodicidad, Date fechaPub, String unidDisponibles, String fabricante, String modelo, String microProcesador,String correlativo) {
        super(fabricante, modelo, microProcesador);
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPub = fechaPub;
        this.unidDisponibles = unidDisponibles;
        this.correlativo = correlativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Date getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(Date fechaPub) {
        this.fechaPub = fechaPub;
    }

    public String getUnidDisponibles() {
        return unidDisponibles;
    }

    public void setUnidDisponibles(String unidDisponibles) {
        this.unidDisponibles = unidDisponibles;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    
    
}
