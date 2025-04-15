package com.example.movies.model;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    private long id;
    private String titulo;
    private int año;
    private String director;
    private String genero;
    private String sinopsis;

    public Pelicula(long id, String titulo, int año, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Pelicula() {        
    }

    // Getters
    public long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getAño() {
        return año;
    }
    public String getDirector() {
        return director;
    }
    public String getGenero() {
        return genero;
    }
    public String getSinopsis() {
        return sinopsis;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
   
}
