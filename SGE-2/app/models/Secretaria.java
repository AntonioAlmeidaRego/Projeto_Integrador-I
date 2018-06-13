package models;

import javax.persistence.Entity;
import javax.swing.text.StyledEditorKit.BoldAction;

import play.db.jpa.Model;

@Entity
public class Secretaria extends Model{
	private String nome, email, senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
