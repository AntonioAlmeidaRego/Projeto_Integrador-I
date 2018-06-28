package interceptors;

import org.junit.Before;

import controllers.Application;
import controllers.SGE;
import models.*;
import play.mvc.Controller;

public class Secure extends Controller {
	
	@Before
	static void checharAutenticacao() {
		
		if(!session.contains("secretaria")) {
			Application.index();
		}
		
		
	}

}
