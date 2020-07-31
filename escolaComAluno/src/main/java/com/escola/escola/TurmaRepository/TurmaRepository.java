package com.escola.escola.TurmaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.escola.escola.Turma.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	public List<Turma> findAllByTurmaContainingIgnoreCase (String turma);
}
