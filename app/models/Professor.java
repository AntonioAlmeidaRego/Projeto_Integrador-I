package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	public String tipoVinculo;
	public String nome;
	public String matricula;
	public String rua;
	public String bairro;
	public String cpf;
	public String dataNascimento;
	public String senha;
	public Blob foto;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@OneToOne(mappedBy="professor")
	public Disciplina disciplina;
	
}
