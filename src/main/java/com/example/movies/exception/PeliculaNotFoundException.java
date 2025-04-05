package com.example.movies.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeliculaNotFoundException extends RuntimeException {
	public PeliculaNotFoundException(Long id) {
        super("La película con id: " + id + " no fue encontrada.");
    }
}
