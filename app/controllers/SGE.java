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
    	Aluno aluno = Alunos.buscaAlunoBD(usuario.getUsuario(), usuario.getSenha());
    	Professor professor = Professores.buscaProfessorBD(usuario.getUsuario(), usuario.getSenha());
    	Secretaria secretaria = Secretarias.buscaSecretariaBD(usuario.getUsuario(), usuario.getSenha());
    	String admistrador = "admin";
    	String senha = "admin";
    	if(admistrador.equals(usuario.getUsuario()) && senha.equals(usuario.getSenha())) {
    		renderTemplate("Administradores/portalAdmin.html",admistrador);
    	}else if(secretaria != null) {
    		renderTemplate("Secretarias/portal_secretaria.html",secretaria);
    	}else if(aluno != null){
    		renderTemplate("Alunos/portal_aluno.html",aluno);
    	}else if(professor != null) {
    		renderTemplate("Professores/portal_professor.html",professor);
    	}else {
    		flash.error("USUÁRIO OU SENHA INVÁLIDOS");
    		renderTemplate("Application/index.html");
    	}
    }  
    
}
