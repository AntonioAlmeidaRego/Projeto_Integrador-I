package controllers;

import java.util.List;

import models.Disciplina;
import models.Professor;
import play.mvc.Controller;

public class Disciplinas extends Controller{
	
	public static void cadastro_disciplina() {
		List<Professor> professor = Professor.findAll();
		render(professor);
	}
	
	public static void salvarDisciplina(Disciplina disciplina) {
		if(disciplina.save() != null) {
			flash.success("Disciplina salva com sucesso!");
			listarDisciplina();
		}else {
			flash.error("Disciplina não foi salva, tente novamente!");
			listarDisciplina();
		}
		
	}
	
	public static void editarDisciplina(Long id) {
		Disciplina disciplina = Disciplina.findById(id);
		List<Professor> professor = Professor.findAll();
		renderTemplate("SGE/cadastro_disciplina.html",disciplina, professor);
	}
    
	
	 public static void listarDisciplina() {
	    	List<Disciplina> disciplina = Disciplina.findAll();
	    	render(disciplina);
	 
	 
	 }
	 
	 public static List<Disciplina> getListaDisciplina(){
	    	List<Disciplina> disciplina = Disciplina.findAll();
	    	return disciplina;
	    }
	 
	 public static Disciplina buscaDisciplina(long id) {
	    	for(Disciplina disciplina : getListaDisciplina()) {
	    		if(disciplina.getId() == id) {
	    			return disciplina;
	    		}
	    	}
	    	return null;
	    }
	 
	 public static void removerDisciplina(long id) {
	    	Disciplina disciplina = buscaDisciplina(id);
	    	if(disciplina.delete() != null) {
	    		flash.success("Disciplina removida com sucesso!");
	    		listarDisciplina();
	    	}else {
	    		flash.error("Disciplina não foi removida!");
	    		listarDisciplina();
	    	}
	    }
	    
}
