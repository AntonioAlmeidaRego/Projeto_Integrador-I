package models;

import javax.persistence.Entity;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	public String tipo_vinculo;
	public String nome;
	public String matricula;
	public String rua;
	public String bairro;
	public String cpf;
	public String certificado_de_nascimento;
	public String senha;
	public Blob foto;
	
}
