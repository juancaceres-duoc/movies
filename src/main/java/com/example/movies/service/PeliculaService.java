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

}
