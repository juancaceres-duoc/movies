package com.example.movies;

public class Pelicula {
    private int id;
    private String titulo;
    private int año;
    private String director;
    private String genero;
    private String sinopsis;

    public Pelicula(int id, String titulo, int año, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    // Getters
    public int getId() {
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

    // No añadiré los setters aún puesto que no se requieren en este caso.
    
   
}
