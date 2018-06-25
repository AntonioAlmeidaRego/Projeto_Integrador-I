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
	public int numeroCasa;
	public String cidade;
	public String ufCidade;
	public String cep;
	public String cpf;
	public String dataNascimento;
	public String senha;
	public String naturalidade;
	public String ufNaturalidade;
	public String sexo;
	public int certidaoCivilNum;
	public int folhaCertidao;
	public int livroCertidao;
	public String cartorioCertidao;
	public int rgNumero;
	public String rgExpedidor;
	public String dataExpedicao;
	public String nomeMae;
	public String nomePai;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	public Turma turma;
	
	@ManyToMany
	@JoinTable(name="alunos_disciplinas")
	public List<Disciplina> disciplina;
	
	 
}
