package controllers;

import java.util.List;

import org.h2.engine.User;

import models.Aluno;
import models.Professor;
import models.Turma;
import play.mvc.Controller;

public class Professores extends Controller{
	
	 public static void portal_professor(Professor professor){
	    render(professor);
	 }
	
	public static void cadastro_professor(){
		List<Turma> turmas = Turma.findAll();
		render(turmas);
	}
	
	public static void editarProfessor(Long id) {
		Professor professor = Professor.findById(id);
		List<Turma> turmas = Turma.findAll();
		renderTemplate("Professores/cadastro_professor.html",professor,turmas);
	}
	
	public static void salvarProfessor(Professor professor) {
    	if(professor.save() != null) {
    		flash.success("Professor salvo com sucesso!");
    		listarProfessor();
    	}else {
    		flash.error("Professor não foi salvo, tente novamente");
    		listarProfessor();
    	}
    	
    }
	
	public static List<Professor> getListaProfessor(){
    	List<Professor> professores = Professor.findAll();
    	return professores;
    }
	
	public static Professor buscaProfessor(long id) {
    	for(Professor professor : getListaProfessor()) {
    		if(professor.getId() == id) {
    			return professor;
    		}
    	}
    	return null;
    }
	
	public static List<Professor> buscaProfessorBD(String matricula, String senha) {
		return Professor.find("matricula = ? and senha = ?", matricula, senha).fetch();
    }
	
	public static void pesquisarAluno(String busca) {
		List<Aluno> alunos = Aluno.find("nome like ? or matricula like ?", "%"+busca+"%", "%"+busca+"%").fetch();
		if(alunos.isEmpty()) {
		   flash.error("Aluno não encontrado!");
		   renderTemplate("Professores/portal_professor.html");
		}
		renderTemplate("Professores/pesquisarAluno.html", alunos);
	}
	
	public static void removerProfessor(long id) {
    	Professor professor = buscaProfessor(id);
    	if(professor.delete() != null) {
    		flash.success("Professor removido com sucesso!");
    		listarProfessor();
    	}else {
    		flash.error("Professor não foi removido!");
    	}    	
    }
	

    public static void listarProfessor(){
    	List<Aluno> professores = Professor.findAll();
    	render(professores);
     } 
    
	
}
