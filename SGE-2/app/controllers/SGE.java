package controllers;

import java.util.List;

import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Secretaria;
import models.Turma;
import models.Usuario;
import play.mvc.Controller;

public class SGE extends Controller{
	
    public static void portal_aluno() {
    	render();
    }
    
    public static void portal_secretaria() {
    	render();
    }
    
    public static void portal_professor(){
    	render();
    }
    public static void esqueceu() {
    	render();
    }
    
    public static void login(Usuario usuario) {
    	Aluno aluno = Alunos.buscaAlunoBD(usuario.getUsuario(), usuario.getSenha());
    	Professor professor = Professores.buscaProfessorBD(usuario.getUsuario(), usuario.getSenha());
    	Secretaria secretaria = Secretarias.buscaSecretariaBD(usuario.getUsuario(), usuario.getSenha());
    	if(secretaria != null) {
    		renderTemplate("SGE/portal_secretaria.html",secretaria);
    	}else if(aluno != null){
    		renderTemplate("SGE/portal-aluno.html",aluno);
    	}else if(professor != null) {
    		renderTemplate("SGE/portal_professor.html",professor);
    	}else {
    		flash.error("USUÁRIO OU SENHA INVÁLIDOS");
    		renderTemplate("Application/index.html");
    	}
    }  
    
    
   /* public static void fotoProfessor(long id) {
    	List<Professor> professor = Professor.findById(id);
    	
    }*/
    
}
