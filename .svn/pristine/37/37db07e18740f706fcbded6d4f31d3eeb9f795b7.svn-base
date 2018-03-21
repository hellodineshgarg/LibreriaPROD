package com.grupoatrium.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoatrium.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	 
	 Page <Autor> NombreContainingAndNacionalidadContainingAndComentariosContaining(String nombre, String nacionalidad, String comentarios ,Pageable pageable);
	 
}
