package com.eecomerce.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eecomerce.farmacia.Service.UsuarioService;
import com.eecomerce.farmacia.model.Usuario;
import com.eecomerce.farmacia.model.UsuarioLogin;
import com.eecomerce.farmacia.repository.RepositoryUsuario;

@RestController
@RequestMapping ("/usuario")
@CrossOrigin("*")
public class ControllerUsuario {

	@Autowired
	private RepositoryUsuario repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin>Autentication(@RequestBody Optional<UsuarioLogin>user)
	{
		return usuarioService.Logar(user).map(resp ->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario>GetById (@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario)
	{
		return ResponseEntity.ok(repository.save(usuario));
	}
}
