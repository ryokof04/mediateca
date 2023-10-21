/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.edu.todopc.dto;

/**
 *
 * @author Patricia Mejia
 */
public class Productos {
    
    private String fabricante;
    private String modelo;
    private String microProcesador;

    public Productos() {
    }
    
    public Productos(String fabricante, String modelo, String microProcesador) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microProcesador = microProcesador;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the microProcesador
     */
    public String getMicroProcesador() {
        return microProcesador;
    }

    /**
     * @param microProcesador the microProcesador to set
     */
    public void setMicroProcesador(String microProcesador) {
        this.microProcesador = microProcesador;
    }
}
