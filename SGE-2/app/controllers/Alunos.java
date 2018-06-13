package controllers;

import java.util.List;

import models.Aluno;
import models.Turma;
import models.Usuario;
import play.mvc.Controller;

public class Alunos extends Controller{
	
	public static void cadastro_aluno(){
		List<Turma> turmas = Turma.findAll();
		render(turmas);
	}
	
	
	public static void salvarAluno(Aluno aluno) {
    	if(aluno.save() != null) {
    		flash.success("Aluno salvo com sucesso!");
    		listarAluno();
    	}else {
    		flash.error("Aluno não foi salvo, tente novamente");
    		listarAluno();
    	}
    }
	
	 public static void listarAluno(){
	    	List<Aluno> aluno = Aluno.findAll();
	    	render(aluno);
	     } 
	    
	 
	 public static List<Aluno> getListaAluno(){
	    	List<Aluno> aluno = Aluno.findAll();
	    	return aluno;
	    }
	    
	 public static Aluno buscaAluno(long id) {
	    	for(Aluno aluno : getListaAluno()) {
	    		if(aluno.getId() == id) {
	    			return aluno;
	    		}
	    	}
	    	return null;
	    }
	    
	    public static Aluno buscaAlunoBD(String nome, String senha) {
	    	for(Aluno aluno : getListaAluno()) {
	    		if(aluno.matricula.equals(nome) && aluno.senha.equals(senha)) {
	    			return aluno;
	    		}
	    	}
	    	return null;
	    }
	    
	    public static Aluno PesquisaAluno(String nome) {
	    	for(Aluno aluno : getListaAluno()) {
	    		if(aluno.nome.equals(nome)) {
	    			return aluno;
	    		}
	    	}
	    	return null;
	    }
	    
	    public static void remover(long id) {
	    	Aluno aluno = buscaAluno(id);
	    	if(aluno.delete() != null) {
	    		flash.success("Aluno removido com sucesso!");
	    		listarAluno();
	    	}else {
	    		flash.error("Aluno não foi removido!");
	    		listarAluno();
	    	}
	    }
	    
	    public static void pesquisarAluno(Usuario usuario) {
	    	Aluno aluno = PesquisaAluno(usuario.getUsuario());
	    	if(aluno != null) {
	    		flash.success("ALUNO ENCONTRADO!");
				renderTemplate("Alunos/pesquisa.html", aluno);
	    	}else {
				flash.error("ALUNO NÃO ENCONTRADO!");
				renderTemplate("Professores/portal_professor.html");
			}
	    }
	    
		
		
		public static void editarAluno(Long id) {
			Aluno aluno = Aluno.findById(id);
			renderTemplate("Alunos/cadastro_aluno.html",aluno);
		}
}
