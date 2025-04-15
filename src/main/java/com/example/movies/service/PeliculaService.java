package com.example.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.repository.PeliculaRepository;
import com.example.movies.model.Pelicula;
import com.example.movies.exception.PeliculaNotFoundException;

import java.util.List;

@Service
public class PeliculaService {   

    @Autowired
    private PeliculaRepository repo;

    public List<Pelicula> obtenerTodas() {
        return repo.findAll();
    }

    public Pelicula obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula guardar(Pelicula pelicula) {
        if(repo.existsById(pelicula.getId())) {
            throw new IllegalArgumentException("Pelicula con ID: "+pelicula.getId()+" ya existe.");
        }else {
            return repo.save(pelicula);
        }        
    }

    public Pelicula actualizar(Long id, Pelicula pelicula) {
        Pelicula existente = repo.findById(id).orElseThrow(() -> new PeliculaNotFoundException(id));
        existente.setTitulo(pelicula.getTitulo());
        existente.setAño(pelicula.getAño()); 
        existente.setDirector(pelicula.getDirector());
        existente.setGenero(pelicula.getGenero());
        existente.setSinopsis(pelicula.getSinopsis());    
        
        return repo.save(existente);
    }

    public void eliminar(Long id) {
        Pelicula pelicula = repo.findById(id).orElseThrow(() -> new PeliculaNotFoundException(id));
        repo.delete(pelicula);
    }


}
