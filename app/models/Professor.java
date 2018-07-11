package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	@Required
	public String tipoVinculo;
	@Required
	public String nome;
	@Required
	public String matricula;
	@Required
	public String rua;
	@Required
	public String bairro;
	@Required
	public String cpf;
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	@Required
	public String senha;
	public Blob foto;
	
	@Required
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@OneToOne(mappedBy="professor")
	public Disciplina disciplina;
	
}
