package com.example.movies.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.movies.hateoas.PeliculaModelAssembler;
import com.example.movies.model.Pelicula;
import com.example.movies.service.PeliculaService;
import com.example.movies.model.ResponseWrapper;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;  

    @Autowired
    private PeliculaModelAssembler peliculaModelAssembler;   

    @GetMapping("/peliculas")
    public ResponseEntity<CollectionModel<EntityModel<Pelicula>>> getPeliculas() {
        List<Pelicula> peliculas = peliculaService.obtenerTodas();

        if (peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        List<EntityModel<Pelicula>> peliculaModels = peliculas.stream()
                .map(peliculaModelAssembler::toModel)
                .toList();
        
        return ResponseEntity.ok(
                CollectionModel.of(peliculaModels,
                        linkTo(methodOn(PeliculaController.class).getPeliculas()).withSelfRel())
        );
    }

    @GetMapping("/peliculas/{id}")
    public ResponseEntity<EntityModel<Pelicula>> getPelicula(@PathVariable long id) {
        Pelicula pelicula = peliculaService.obtenerPorId(id);
        return ResponseEntity.ok(
                peliculaModelAssembler.toModel(pelicula)
        );
    }

    @PostMapping
    public  ResponseEntity<EntityModel<Pelicula>> crearPelicula(@RequestBody Pelicula pelicula) {
        Pelicula creada = peliculaService.guardar(pelicula);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(peliculaModelAssembler.toModel(creada));
    }

    @PutMapping("/peliculas/{id}")
    public ResponseEntity<EntityModel<Pelicula>> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula actualizada = peliculaService.actualizar(id, pelicula);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(peliculaModelAssembler.toModel(actualizada));
    }

    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<ResponseWrapper<Void>> eliminarPelicula(@PathVariable long id) {
        peliculaService.eliminar(id);

        return ResponseEntity                
                .status(HttpStatus.OK)
                .body(new ResponseWrapper<>("Pelicula eliminada",0,null));
    }

    
}
