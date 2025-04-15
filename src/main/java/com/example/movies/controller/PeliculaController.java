package com.example.movies.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.movies.model.Pelicula;
import com.example.movies.service.PeliculaService;
import com.example.movies.model.ResponseWrapper;


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

    @PostMapping
    public ResponseEntity<ResponseWrapper<Pelicula>> crearPelicula(@RequestBody Pelicula pelicula) {
        Pelicula creada = peliculaService.guardar(pelicula);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseWrapper<>("Pelicula creada",1,List.of(creada)));
    }

    @PutMapping("/peliculas/{id}")
    public ResponseEntity<ResponseWrapper<Pelicula>> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula actualizada = peliculaService.actualizar(id, pelicula);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper<>("Pelicula actualizada",1,List.of(actualizada)));
    }

    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<ResponseWrapper<Void>> eliminarPelicula(@PathVariable long id) {
        peliculaService.eliminar(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper<>("Pelicula eliminada",0,null));
    }

    
}
