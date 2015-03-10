package br.unibh;

import java.math.BigDecimal;
import java.util.Date;

import br.unibh.models.Aluno;
import br.unibh.models.Professor;
import br.unibh.persistence.AlunoDAO;


public class OlaMundo {

	public static void main(String[] args) {
	
		Aluno aluno1;
		Aluno aluno2;
		Aluno aluno3;
		
		Professor prof1;
		
		aluno1 = new Aluno(1L,113113253L,"Leonardo","00000000000",new Date());
		aluno2 = new Aluno(2L,111013243L,"Gilberto","00000000000");
		aluno3 = new Aluno(3L,111013153L,"Tobias");
		
		prof1 = new Professor(1L,"Cruvinel","0000000000");
		prof1.setSalario(new BigDecimal(10000.64));
		
		System.out.println(aluno1);
		System.out.println(aluno2);
		System.out.println(aluno3);
		System.out.println(prof1);
		System.out.printf("O bônus do professor %s é de %f",prof1.getNome(), prof1.getSalario().multiply(BigDecimal.valueOf(Professor.BONUS)));
		System.out.printf("\nMatrícula de %s é %s",aluno1.getNome(),Aluno.validaMatricula(aluno1.getMatricula().toString()));
		System.out.println("\n==========================================================");
		System.out.println("Alunos do Banco: ");
		AlunoDAO alunoDao = new AlunoDAO();
		
		for(Aluno aluno: alunoDao.findAll()) {
			System.out.println(aluno);
		}
		
	}

}
