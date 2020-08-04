package com.eecomerce.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eecomerce.farmacia.model.Categoria;



@Repository
public interface RepositoryCategoria extends JpaRepository<Categoria, Long>
{
	 //public List<Categoria> findAllByDescriçãoContainingIgnoreCase(String descrição);
	}

