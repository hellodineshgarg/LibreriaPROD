package com.grupoatrium.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.grupoatrium.modelo.User;

public interface UserRepostory extends JpaRepository<User, Long> {

	User findByUsername(String username);
	Page<User> findByUsernameContaining(String username, Pageable pageable);
	
	Page<User> findByUsernameContainingAndEnabledTrue(String username,Boolean enabled, Pageable pageable);
}
