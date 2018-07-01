package interceptors;

import org.junit.Before;

import annotations.Admin;
import controllers.Application;
import models.*;
import play.mvc.Controller;

public class Secure extends Controller {
	
	@Before
	static void checharAutenticacao() {
		String secretaria = session.get("secretaria");
		String aluno = session.get("aluno");
		String professor = session.get("professor");
		
		boolean seguranca = getControllerAnnotation(Admin.class) != null ||
	   			getActionAnnotation(Admin.class) != null;
		
		if(seguranca && secretaria == null || aluno == null || professor == null) {
			flash.error("Por favor, entre com seu login e senha.");
			Application.index();
		}
	}

}
