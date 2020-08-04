package com.rede.minhaRedeSocial.controller;

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
import com.rede.minhaRedeSocial.model.Tema;
import com.rede.minhaRedeSocial.repository.RepositoryTema;

@RestController
@RequestMapping ("/tema")
@CrossOrigin("*")

public class ControllerTema {
	
	@Autowired
	private RepositoryTema repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>>GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
    
	@GetMapping ("{id}")
	public ResponseEntity<Tema>getById(@PathVariable long id)
	{
		return repository.findById(id).map(resp ->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@PostMapping
	public ResponseEntity<Tema>Post(@RequestBody Tema tema)
	{
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema>Put(@RequestBody Tema tema)
	{
	return ResponseEntity.status(HttpStatus.OK)
			.body(repository.save(tema));
	}
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}
}
