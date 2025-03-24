package com.example.movies;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaController {
    private List<Pelicula> peliculaList = new ArrayList<>();

    public PeliculaController() {
        peliculaList.add(new Pelicula(
                1,
                "Star Wars: Episodio IV - Una Nueva Esperanza",
                1977,
                "George Lucas",
                "Sci-Fi",
                "Luke Skywalker, junto a aliados, lucha contra el Imperio, rescata a la Princesa Leia y destruye la Estrella de la Muerte."));
        peliculaList.add(new Pelicula(
                2,
                "El Padrino",
                1972,
                "Francis Ford Coppola",
                "Mafia",
                "El envejecido patriarca de una dinastía criminal transfiere el control de su imperio clandestino a su hijo reticente."));
        peliculaList.add(new Pelicula(
                3,
                "El Señor de los Anillos: La Comunidad del Anillo",
                2001,
                "Peter Jackson",
                "Fantasía",
                "Un joven hobbit llamado Frodo Bolsón, hereda un anillo mágico y se embarca en una aventura para destruirlo."));
                peliculaList.add(new Pelicula(
                4,
                "Volver al Futuro",
                1985,
                "Robert Zemeckis",
                "Ciencia Ficción",
                "Un joven es transportado al pasado en un DeLorean modificado por su amigo científico, y debe asegurarse de que sus padres se conozcan."));
        peliculaList.add(new Pelicula(
                5,
                "El Club de los Cinco",
                1985,
                "John Hughes",
                "Drama",
                "Cinco estudiantes de secundaria, con personalidades muy diferentes, pasan un sábado castigados en la escuela."));
    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaList;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPelicula(@PathVariable int id) {
        for (Pelicula pelicula : peliculaList) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }
        return null;
    }
    
}
