package models;

import javax.persistence.Entity;
import javax.swing.text.StyledEditorKit.BoldAction;

import play.db.jpa.Model;

@Entity
public class Secretaria extends Model{
	public String nome, matricula, senha;

}
