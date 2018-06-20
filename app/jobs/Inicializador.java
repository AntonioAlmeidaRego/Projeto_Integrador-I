package jobs;

import models.Aluno;
import models.Professor;
import models.Secretaria;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		
		if(Secretaria.count() == 0) {			
			Secretaria secretaria = new Secretaria();
			secretaria.matricula = "123";
			secretaria.senha = "123";
			secretaria.save();
			
			/*Aluno aluno = new Aluno();
			aluno.nome = "Antônio";
			aluno.senha = "123";
			aluno.save();
			
			Aluno aluno2 = new Aluno();
			aluno2.nome = "Francisco Leandro";
			aluno2.senha = "123";
			aluno2.save();*/
			
			Professor prof = new Professor();
			prof.nome = "João Helis Bernardo";
			prof.senha = "123";
			prof.save();
			
			Professor prof2 = new Professor();
			prof2.nome = "Daniel Aguiar";
			prof2.senha = "123";
			prof2.save();

		}
	}
}
