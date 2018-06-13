package controllers;

import java.util.List;

import models.Secretaria;
import play.mvc.Controller;

public class Secretarias extends Controller{
	 public static List<Secretaria> getListaSecretaria(){
	    	List<Secretaria> secretaria = Secretaria.findAll();
	    	return secretaria;
	    }
	    
	    public static Secretaria buscaSecretariaBD(String nome, String senha) {
	    	for(Secretaria secretaria : getListaSecretaria()) {
	    		if(secretaria.getNome().equals(nome) && secretaria.getSenha().equals(senha)) {
	    			return secretaria;
	    		}
	    	}
	    	return null;
	    }
	    
	   
}
