package controllers;

import java.util.List;

import models.Turma;
import play.mvc.Controller;

public class Turmas extends Controller{
	
	public static void cadastro_turma() {
		render();
	}
	
	
	public static void salvarTurma(Turma turma) {
		if(turma.save() != null) {
			flash.success("Turma salva com sucesso!");
			listarTurma();
		}else {
			flash.error("Turma não foi salva, tente novamente");
			listarTurma();
		}
	}
	

    public static void listarTurma(){
    	List<Turma> turma = Turma.findAll();
    	render(turma);
     } 
	
	public static void editarTurma(Long id) {
		Turma turma = Turma.findById(id);
		renderTemplate("SGE/cadastro_turma.html",turma);
	}
	
	public static List<Turma> getListaTurma(){
    	List<Turma> turma = Turma.findAll();
    	return turma;
    }
	
	public static Turma buscaTurma(long id) {
    	for(Turma turma : getListaTurma()) {
    		if(turma.getId() == id) {
    			return turma;
    		}
    	}
    	return null;
    }
	
	public static void removerTurma(long id) {
    	Turma turma = buscaTurma(id);
    	if(turma.delete() != null) {
    		flash.success("Turma removida com sucesso!");
    		listarTurma();
    	}else {
    		flash.error("Turma não foi removida!");
    		listarTurma();
    	}
    	
    }
}
