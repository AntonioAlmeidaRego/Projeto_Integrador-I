package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.GenericModel;

@Entity
public class Turma extends GenericModel{
	
	@Id
	private int id;
	
	private String nome_turma;
	private int numero_sala;
	private String turno;
	
	
	public String getNome_turma() {
		return nome_turma;
	}
	public void setNome_turma(String nome_turma) {
		this.nome_turma = nome_turma;
	}
	public int getNumero_sala() {
		return numero_sala;
	}
	public void setNumero_sala(int numero_sala) {
		this.numero_sala = numero_sala;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	@OneToMany(mappedBy="turma")
	public List<Aluno> alunos;
	
	/*@OneToOne(mappedBy="turma")
	public Professor professor;*/
	
	
	
}
