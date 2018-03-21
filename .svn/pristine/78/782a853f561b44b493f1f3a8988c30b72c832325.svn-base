package com.grupoatrium.repositorios;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.grupoatrium.modelo.Direccion;


//@org.springframework.transaction.annotation.Transactional
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

	 Page<Direccion> findByPoblacionContainingAndCalleContainingAndProvinciaContaining(String poblacion ,String calle, String provincia, Pageable pageable);
	 
	 Page<Direccion> findByIdLike(Long id, Pageable pageable);
}
