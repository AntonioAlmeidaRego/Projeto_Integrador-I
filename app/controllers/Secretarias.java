package controllers;

import java.util.List;

import interceptors.Secure;
import models.Aluno;
import models.Professor;
import models.Secretaria;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Secretarias extends Controller{
	
		public static void salvarSecretaria(Secretaria secretaria) {
			System.out.println(params.get("excluirFoto"));
			if(params.get("excluirFoto") != null) {
				secretaria.foto.getFile().delete();
			}
			
			secretaria.save();
			flash.success("Secretário(a) salvo (a) com sucesso!");
			listarSecretaria();			
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
	    	return Secretaria.find("matricula = ? and senha =?", matricula, senha).first();
	    }
	    
	    public static void removerSecretaria(long id) {
	    	Secretaria secretaria = Secretaria.findById(id);
	    	if(secretaria.delete() != null) {
	    		flash.success("Secretario(a) removido(a) com sucesso!");
	    		listarSecretaria();
	    	}else {
	    		flash.error("Houve um erro, tente novamente!");
	    		listarSecretaria();
	    	}
	    }
	    
		public static void editarSecretaria(Long id) {
			Secretaria secretaria = Secretaria.findById(id);
			renderTemplate("Administradores/cadastrarSecretaria.html",secretaria);
		}
		

	    public static void portal_secretaria() {
	    	List<Secretaria> secretaria = Secretaria.findAll();
	    	long alunos = Aluno.count();
	    	render(secretaria,alunos);
	    }
	    
	    
	    public static void fotoSecretaria(Long id) {
	    	Secretaria secretaria = Secretaria.findById(id);
	    	notFoundIfNull(secretaria);
	    	response.setContentTypeIfNotSet(secretaria.foto.type());
	    	renderBinary(secretaria.foto.get());
	    }
}
