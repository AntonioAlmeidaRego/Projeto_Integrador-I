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
   
    public static void esqueceu() {
    	render();
    }
    
    public static void login(Usuario usuario) {
    	List<Aluno> aluno = Alunos.buscaAlunoBD(usuario.getUsuario(), usuario.getSenha());
    	List<Professor> professor = Professores.buscaProfessorBD(usuario.getUsuario(), usuario.getSenha());
    	List<Secretaria> secretaria = Secretarias.buscaSecretariaBD(usuario.getUsuario(), usuario.getSenha());
    	String admistrador = "admin";
    	String senha = "admin";
    	if(admistrador.equals(usuario.getUsuario()) && senha.equals(usuario.getSenha())) {
    		renderTemplate("Administradores/portal_admin.html",admistrador);
    	}else if(!secretaria.isEmpty()) {
    		renderTemplate("Secretarias/portal_secretaria.html",secretaria);
    	}else if(!aluno.isEmpty()){
    		renderTemplate("Alunos/portal_aluno.html",aluno);
    	}else if(!professor.isEmpty()) {
    		renderTemplate("Professores/portal_professor.html",professor);
    	}else {
    		flash.error("USUÁRIO OU SENHA INVÁLIDOS");
    		renderTemplate("Application/index.html");
    	}
    }  
    
}
