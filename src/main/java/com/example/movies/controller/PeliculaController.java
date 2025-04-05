package com.example.movies.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.movies.model.Pelicula;
import com.example.movies.service.PeliculaService;


import java.util.List;

@RestController

public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;    

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaService.obtenerTodas();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPelicula(@PathVariable long id) {
        return peliculaService.obtenerPorId(id);
    }
    
}
