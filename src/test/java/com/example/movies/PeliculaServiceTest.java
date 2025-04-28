package com.example.movies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.example.movies.service.PeliculaService;
import com.example.movies.model.Pelicula;
import com.example.movies.repository.PeliculaRepository;

public class PeliculaServiceTest {

    
    private PeliculaService peliculaService; 
    private PeliculaRepository peliculaRepository;

    @BeforeEach
    public void setUp() {
        peliculaRepository = mock(PeliculaRepository.class);
        peliculaService = new PeliculaService(peliculaRepository);
    }   

    @Test
    public void testGuardarPelicula() {  

        Pelicula pelicula = new Pelicula(
                1L, "Pretty in Pink", 1986, "Howard Deutch", "Comedia romántica, Drama",
                "Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.");

        when(peliculaRepository.save(any(Pelicula.class))).thenReturn(pelicula);   
        Pelicula resultado = peliculaService.guardar(pelicula);
        
        assertEquals("Pretty in Pink", resultado.getTitulo());
        assertEquals(1986, resultado.getAño());
        assertEquals("Howard Deutch", resultado.getDirector()); 
        assertEquals("Comedia romántica, Drama", resultado.getGenero());
        assertEquals("Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.", resultado.getSinopsis()); 
    }

    @Test
    public void testActualizarPelicula() {  

        Pelicula peliculaExistente = new Pelicula(
                1L, "Pretty in Pink", 1985, "John Hughes", "Comedia romántica",
                "Test sinopsis existente.");

        Pelicula peliculaActualizada = new Pelicula(
                1L, "Pretty in Pink", 1986, "Howard Deutch", "Comedia romántica, Drama",
                "Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.");

        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(peliculaExistente));
        when(peliculaRepository.save(peliculaExistente)).thenReturn(peliculaExistente);
        
        Pelicula resultado = peliculaService.actualizar(1L, peliculaActualizada);
        
        assertEquals("Pretty in Pink", resultado.getTitulo());
        assertEquals(1986, resultado.getAño());
        assertEquals("Howard Deutch", resultado.getDirector()); 
        assertEquals("Comedia romántica, Drama", resultado.getGenero());
        assertEquals("Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.", resultado.getSinopsis()); 
    }

   @Test
    public void testEliminarPelicula() {  

        Pelicula pelicula = new Pelicula(
                1L, "Pretty in Pink", 1986, "Howard Deutch", "Comedia romántica, Drama",
                "Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.");

        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(pelicula));        
        peliculaService.eliminar(1L);
        
        verify(peliculaRepository, times(1)).delete(pelicula); 
    }

    @Test
    public void testObtenerPorId() {  

        Pelicula pelicula = new Pelicula(
                1L, "Pretty in Pink", 1986, "Howard Deutch", "Comedia romántica, Drama",
                "Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.");

        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(pelicula));        
        Pelicula resultado = peliculaService.obtenerPorId(1L);
        
        assertEquals("Pretty in Pink", resultado.getTitulo());
        assertEquals(1986, resultado.getAño());
        assertEquals("Howard Deutch", resultado.getDirector()); 
        assertEquals("Comedia romántica, Drama", resultado.getGenero());
        assertEquals("Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.", resultado.getSinopsis()); 
    }

    @Test
    public void testObtenerTodas() {  
        Pelicula pelicula1 = new Pelicula(
                1L, "Pretty in Pink", 1986, "Howard Deutch", "Comedia romántica, Drama",
                "Una joven de clase media se enamora de un chico rico, pero su mejor amigo está enamorado de ella.");

        Pelicula pelicula2 = new Pelicula(
                2L, "Fast Times at Ridgemont High", 1982, "Amy Heckerling", "Comedia adolescente",
                "Un grupo de adolescentes navega por la vida en un instituto californiano.");

        when(peliculaRepository.findAll()).thenReturn(List.of(pelicula1, pelicula2));  
              
        List<Pelicula> resultado = peliculaService.obtenerTodas();
        
        assertEquals(2, resultado.size());
        assertEquals("Pretty in Pink", resultado.get(0).getTitulo());
        assertEquals("Fast Times at Ridgemont High", resultado.get(1).getTitulo()); 
    }
}
