package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	
	public String nome;
	public String matricula;
	public String rua;
	public String bairro;
	public String cpf;
	public String certificado_de_nascimento;
	public String senha;
	
	@ManyToOne
		@JoinColumn(name="turma_id")
	public Turma turma;
	
	 
}
