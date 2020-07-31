package com.escola.escola.TurmaController;

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

import com.escola.escola.Turma.Turma;
import com.escola.escola.TurmaRepository.TurmaRepository;


@RestController
@RequestMapping ("/turma")
@CrossOrigin ("*")
public class TurmaController 
{ 
  @Autowired
  private TurmaRepository repository;
  
  @GetMapping 
  public ResponseEntity<List<Turma>>GetAll()
  {
	  return ResponseEntity.ok(repository.findAll());
  }
  
  @GetMapping ("/{id}")
  public ResponseEntity<Turma>GetById(@PathVariable long id)
  {
	  return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
             .orElse(ResponseEntity.badRequest().build());
  }
  
  @PostMapping 														
	public ResponseEntity<Turma>Post(@RequestBody Turma Turma )
  { 		
		return ResponseEntity.status(HttpStatus.CREATED) 	//Para POST e PUT é necessário utilizar o body para inserir os dados//		
				.body(repository.save(Turma));
  }
  @PutMapping
  public ResponseEntity<Turma>Put(@RequestBody Turma Turma)
  {
	  return ResponseEntity.status(HttpStatus.OK) 
			  .body(repository.save(Turma));
  }
  @DeleteMapping ("/{id}")
  public void Delete (@PathVariable long id)
  {
	  repository.deleteById(id);
  }
}
