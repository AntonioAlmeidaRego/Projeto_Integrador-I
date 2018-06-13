package controllers;

import java.util.List;

import models.Aluno;
import models.Secretaria;
import play.mvc.Controller;

public class Secretarias extends Controller{
	
		public static void salvarSecretaria(Secretaria secretaria) {
			if(secretaria.save() != null) {
				flash.success("Secretaria salva com sucesso!");
				listarSecretaria();
			}else {
				flash.error("Secretaria não foi salva, tente novamente");
				listarSecretaria();
			}
		}
		
		public static void listarSecretaria(){
	    	List<Secretaria> secretarias = Secretaria.findAll();
	    	render(secretarias);
	     } 
	
	 	public static List<Secretaria> getListaSecretaria(){
	    	List<Secretaria> secretaria = Secretaria.findAll();
	    	return secretaria;
	    }
	    
	    public static Secretaria buscaSecretariaBD(String matricula, String senha) {
	    	for(Secretaria secretaria : getListaSecretaria()) {
	    		if(secretaria.matricula.equals(matricula) && secretaria.senha.equals(senha)) {
	    			return secretaria;
	    		}
	    	}
	    	return null;
	    }
	    
	    public static void removerSecretaria(long id) {
	    	Secretaria secretaria = Secretaria.findById(id);
	    	if(secretaria.delete() != null) {
	    		flash.success("Secretaria removida com sucesso!");
	    		listarSecretaria();
	    	}else {
	    		flash.error("Secretaria não foi removida!");
	    		listarSecretaria();
	    	}
	    }
	    
		public static void editarSecretaria(Long id) {
			Secretaria secretaria = Secretaria.findById(id);
			renderTemplate("Administradores/cadastro_secretaria.html",secretaria);
		}
	   
}
