package com.rede.minhaRedeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rede.minhaRedeSocial.model.Tema;

@Repository
public interface RepositoryTema extends JpaRepository<Tema, Long>
{

}
