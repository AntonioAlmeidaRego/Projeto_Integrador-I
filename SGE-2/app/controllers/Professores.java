package controllers;

import java.util.List;

import models.Aluno;
import models.Professor;
import models.Turma;
import play.mvc.Controller;

public class Professores extends Controller{
	
	public static void cadastro_professor(){
		List<Turma> turmas = Turma.findAll();
		render(turmas);
	}
	
	public static void editarProfessor(Long id) {
		Professor professor = Professor.findById(id);
		renderTemplate("SGE/cadastro_professor.html",professor);
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
    	List<Professor> professor = Professor.findAll();
    	return professor;
    }
	
	public static Professor buscaProfessor(long id) {
    	for(Professor professor : getListaProfessor()) {
    		if(professor.getId() == id) {
    			return professor;
    		}
    	}
    	return null;
    }
	
	public static Professor buscaProfessorBD(String nome, String senha) {
    	for(Professor professor : getListaProfessor()) {
    		if(professor.getNome().equals(nome) && professor.getSenha().equals(senha)) {
    			return professor;
    		}
    	}
    	return null;
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
    	List<Aluno> professor = Professor.findAll();
    	render(professor);
     } 
    
	
}
