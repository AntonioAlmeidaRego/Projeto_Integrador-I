package models;

import javax.persistence.Entity;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Secretaria extends Model{
	public String nome; 
	public String matricula; 
	public String senha; 
	public String cpf;
	public Blob foto;

}
