package models;

import javax.persistence.Entity;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	private String tipo_vinculo;
	private String nome;
	private String matricula;
	private String rua;
	private String bairro;
	private String cpf;
	private String certificado_de_nascimento;
	private String senha;
	private Blob foto;
	
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo_vinculo() {
		return tipo_vinculo;
	}
	public void setTipo_vinculo(String tipo_vinculo) {
		this.tipo_vinculo = tipo_vinculo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCertificado_de_nascimento() {
		return certificado_de_nascimento;
	}
	public void setCertificado_de_nascimento(String certificado_de_nascimento) {
		this.certificado_de_nascimento = certificado_de_nascimento;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
	
	
}
