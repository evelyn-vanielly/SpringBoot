package com.rede.minhaRedeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rede.minhaRedeSocial.model.Postagem;

@Repository
public interface RepositoryPostagem extends JpaRepository<Postagem, Long> {

}
