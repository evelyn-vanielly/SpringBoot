package com.escola.escola.Turma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table (name = "db_turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@NotNull
	private String Turma;
	
	@NotNull
	private boolean Ativo;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public String getTurma() {
		return Turma;
	}

	public void setTurma(String turma) {
		Turma = turma;
	}
	
	
}
