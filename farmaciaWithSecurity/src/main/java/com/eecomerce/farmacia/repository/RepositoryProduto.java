package com.eecomerce.farmacia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eecomerce.farmacia.model.Produto;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Long>
{
	 //public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	}