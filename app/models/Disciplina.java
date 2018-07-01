package models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@Entity
public class Disciplina extends Model{
	
	public String nomeDisciplina;
	
	
	@ManyToMany(mappedBy="disciplina")
	public List<Aluno> alunos;
	
	@OneToOne
	@JoinColumn(name="professor_id")
	public Professor professor;
	
}
