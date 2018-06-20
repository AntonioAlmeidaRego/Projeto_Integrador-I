package controllers;

import java.util.List;

import models.Disciplina;
import models.Professor;
import play.mvc.Controller;

public class Disciplinas extends Controller{
	
	public static void cadastro_disciplina() {
		List<Professor> professores = Professor.findAll();
		render(professores);
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
	    	List<Disciplina> disciplinas = Disciplina.findAll();
	    	render(disciplinas);
	 }
	 
	 public static List<Disciplina> getListaDisciplina(){
	    	List<Disciplina> disciplinas = Disciplina.findAll();
	    	return disciplinas;
	    }
	 
	  
	 public static void removerDisciplina(int id) {
	    	Disciplina disciplina = Disciplina.findById(id);
	    	if(disciplina.delete() != null) {
	    		flash.success("Disciplina removida com sucesso!");
	    		listarDisciplina();
	    	}else {
	    		flash.error("Disciplina não foi removida!");
	    		listarDisciplina();
	    	}
	    }
	    
}
