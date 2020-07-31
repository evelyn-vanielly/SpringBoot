package com.escola.escola.TurmaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola.Turma.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
 public List<Aluno> findAllByNomeContainingIgnoreCase(String nome);
}
