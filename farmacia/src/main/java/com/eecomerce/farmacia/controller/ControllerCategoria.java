package com.eecomerce.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eecomerce.farmacia.model.Categoria;
import com.eecomerce.farmacia.repository.RepositoryCategoria;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin("*")
public class ControllerCategoria {
	
@Autowired
private RepositoryCategoria repository;

@GetMapping
public ResponseEntity<List<Categoria>>GetAll()
			{
	return ResponseEntity.ok(repository.findAll());
			}
@GetMapping ("/{id}")
public ResponseEntity<Categoria>GetById(@PathVariable long id )
			{
	return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.badRequest().build());
			}
@PostMapping
public ResponseEntity<Categoria>Post (@RequestBody Categoria categoria)
			{
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(categoria));	
			}
@PutMapping
public ResponseEntity<Categoria>Put(@RequestBody Categoria categoria)
			{
	return ResponseEntity.status(HttpStatus.OK)
			.body(repository.save(categoria));
			}
@DeleteMapping("/{id}")
public void Delete(@PathVariable long id)
			{
	repository.deleteById(id);
			}
}
