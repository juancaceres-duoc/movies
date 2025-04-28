package com.example.movies.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.example.movies.controller.PeliculaController;
import com.example.movies.model.Pelicula;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PeliculaModelAssembler implements RepresentationModelAssembler<Pelicula, EntityModel<Pelicula>> {

    @Override
    public EntityModel<Pelicula> toModel(Pelicula pelicula) {
        return EntityModel.of(
                pelicula,
                linkTo(methodOn(PeliculaController.class).getPelicula(pelicula.getId())).withSelfRel(),
                linkTo(methodOn(PeliculaController.class).getPeliculas()).withRel("all"),
                linkTo(methodOn(PeliculaController.class).actualizarPelicula(pelicula.getId(), null)).withRel("update"),
                linkTo(methodOn(PeliculaController.class).eliminarPelicula(pelicula.getId())).withRel("delete")
                );
                                

    

    }
}

