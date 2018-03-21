package com.grupoatrium.repositorios;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
	
	
	Page<Libro> findByIsbnContainingAndTituloContainingAndPublicacionContainingAndPrecioLessThanAndDescripcionContaining(String isbn, String titulo, int publicacion,double precio, String descripcion, Pageable pageable);
	Page<Libro> findByIsbnContainingAndTituloContainingAndDescripcionContaining(String isbn, String titulo, String descripcion, Pageable pageable);
	
	}
