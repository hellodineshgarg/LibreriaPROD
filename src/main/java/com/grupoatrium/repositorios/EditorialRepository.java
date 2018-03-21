package com.grupoatrium.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;

public interface EditorialRepository  extends JpaRepository<Editorial, Long> {
	
	Page<Editorial> findByNifContainingAndNombreContaining(String nif, String nombre, Pageable pageable);

}
