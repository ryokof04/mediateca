/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.edu.todopc.dto;

/**
 *
 * @author Patricia Mejia
 */
public class Libros extends Productos {
    
    private Long id;
    private String titulo;
    private String autor;
    private String numeroPaginas;
    private String editorial;
    private String isbn;
    private String anioPub;
    private String unidadesDisponibles;
    private String correlativo;

    public Libros() {
    }

    public Libros(Long id, String titulo, String autor, String numeroPaginas, String editorial, String isbn, String anioPub, String unidadesDisponibles, String correlativo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPub = anioPub;
        this.unidadesDisponibles = unidadesDisponibles;
        this.correlativo = correlativo;
    }
    
    public Libros(String titulo, String autor, String numeroPaginas, String editorial, String isbn, String anioPub, String unidadesDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPub = anioPub;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Libros(Long id, String titulo, String autor, String numeroPaginas, String editorial, String isbn, String anioPub, String unidadesDisponibles, String fabricante, String modelo, String microProcesador) {
        super(fabricante, modelo, microProcesador);
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPub = anioPub;
        this.unidadesDisponibles = unidadesDisponibles;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAnioPub() {
        return anioPub;
    }

    public void setAnioPub(String anioPub) {
        this.anioPub = anioPub;
    }

    public String getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(String unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
    
    
    
    
}
