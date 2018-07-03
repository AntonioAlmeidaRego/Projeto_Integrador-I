package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	@Required
	public String nome;
	@Required
	public String matricula;
	@Required
	public String rua;
	@Required
	public String bairro;
	@Required
	public int numeroCasa;
	@Required
	public String cidade;
	@Required
	public String ufCidade;
	@Required
	public String cep;
	@Required
	public String cpf;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	
	@Required
	public String senha;
	@Required
	public String naturalidade;
	@Required
	public String ufNaturalidade;
	@Required
	public String sexo;
	@Required
	public int certidaoCivilNum;
	@Required
	public int folhaCertidao;
	@Required
	public int livroCertidao;
	@Required
	public String cartorioCertidao;
	@Required
	public int rgNumero;
	@Required
	public String rgExpedidor;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataExpedicao;
	@Required
	public String nomeMae;
	@Required
	public String nomePai;
	public Blob foto;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@ManyToMany
	@JoinTable(name="alunos_disciplinas")
	public List<Disciplina> disciplina;
	
	 
}
