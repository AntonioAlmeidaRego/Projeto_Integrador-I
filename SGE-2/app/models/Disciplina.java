package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.GenericModel;

@Entity
public class Disciplina extends GenericModel{
	
	@Id
	private int id; 
	
	private String nome_da_disciplina;
	private String responsavel;
	
	
	public String getNome_da_disciplina() {
		return nome_da_disciplina;
	}
	public void setNome_da_disciplina(String nome_da_discipina) {
		this.nome_da_disciplina = nome_da_discipina;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	@ManyToOne
	public Aluno alunos;
	
	//@OneToOne
	//public Professor professor;
	
	
}
