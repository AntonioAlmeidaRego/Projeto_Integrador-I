package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	
	public String nome;
	public String matricula;
	public String rua;
	public String bairro;
	public String cpf;
	public String dataNascimento;
	public String senha;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@ManyToMany
	@JoinTable(name="alunos_disciplinas")
	public List<Disciplina> disciplina;
	
	 
}
