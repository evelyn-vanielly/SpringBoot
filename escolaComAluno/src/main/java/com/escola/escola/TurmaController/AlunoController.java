package com.escola.escola.TurmaController;

import java.util.List;

import javax.persistence.Entity;

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

import com.escola.escola.Turma.Aluno;
import com.escola.escola.Turma.Turma;
import com.escola.escola.TurmaRepository.AlunoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping 														
	public ResponseEntity<Aluno>Post(@RequestBody Aluno aluno )
      { 		
		return ResponseEntity.status(HttpStatus.CREATED) 			
				.body(repository.save(aluno));
      }
	
	@PutMapping
    public ResponseEntity<Aluno>Put(@RequestBody Aluno aluno)
	{
	  return ResponseEntity.ok(repository.save(aluno));
	}
	
	@DeleteMapping ("/{id}")
    public void Delete (@PathVariable long id)
	{
	  repository.deleteById(id);
	}
	
}
