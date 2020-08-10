package com.rede.minhaRedeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rede.minhaRedeSocial.model.Usuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

	
}
