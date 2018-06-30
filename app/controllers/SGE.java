package controllers;

import java.util.List;

import annotations.Admin;
import models.Administrador;
import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Secretaria;
import models.Turma;

import play.mvc.Controller;

public class SGE extends Controller{
   
    public static void esqueceu() {
    	render();
    }
    
    public static void login(String matricula, String senha) {
    	Secretaria secretaria = Secretaria.find("matricula = ? and senha = ?", matricula, senha).first();
    	Professor professor = Professor.find("matricula = ? and senha = ?", matricula, senha).first();
    	Aluno aluno = Aluno.find("matricula = ? and senha = ?", matricula, senha).first();
    	Administrador admin = new Administrador();
    	admin.matricula = "admin";
    	admin.senha = "admin";
    	
    	
    	if(admin.matricula.equals(matricula) && admin.senha.equals(senha)) {
    		session.put("admin", admin);
    		renderTemplate("Administradores/portalAdmin.html",admin);
    	} else if(secretaria != null) {
    		session.put("nome", secretaria.nome);
    		session.put("secretaria", secretaria);
    		renderTemplate("Secretarias/portal_secretaria.html",secretaria);
    	} else if(professor != null) {
    		session.put("professor", professor);
    		renderTemplate("Professores/portal_professor.html",professor);
    	} else if(aluno != null) {
    		session.put("aluno", aluno);
    		renderTemplate("Alunos/portal_aluno.html",aluno);
    	}else {
    		flash.error("Matricula ou senha inválido");
    		params.flash();
    		renderTemplate("Application/index.html");
    	}
    }
    
    public static void logout() {
    	session.clear();
    	System.out.println("logout");
    	renderTemplate("Application/index.html");
    	
    }
   
    
    
    
    // public static void login(Usuario usuario) {
    //	Aluno aluno = Alunos.buscaAlunoBD(usuario.getUsuario(), usuario.getSenha());
    	//Professor professor = Professores.buscaProfessorBD(usuario.getUsuario(), usuario.getSenha());
    	//Secretaria secretaria = Secretarias.buscaSecretariaBD(usuario.getUsuario(), usuario.getSenha());
    //	String admistrador = "admin";
    //	String senha = "admin";
    //	if(admistrador.equals(usuario.getUsuario()) && senha.equals(usuario.getSenha())) {
    //		renderTemplate("Administradores/portalAdmin.html",admistrador);
    //	}else if(secretaria != null) {
    //		renderTemplate("Secretarias/portal_secretaria.html",secretaria);
    //	}else if(aluno != null){
    //		renderTemplate("Alunos/portal_aluno.html",aluno);
    //	}else if(professor != null) {
    //		renderTemplate("Professores/portal_professor.html",professor);
    //	}else {
    //		flash.error("USUÁRIO OU SENHA INVÁLIDOS");
    //		renderTemplate("Application/index.html");
    //	}
   // }  
    
}
