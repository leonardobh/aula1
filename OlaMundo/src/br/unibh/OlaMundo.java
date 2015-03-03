package br.unibh;

import java.math.BigDecimal;
import java.util.Date;

public class OlaMundo {

	public static void main(String[] args) {
	
		Aluno aluno1;
		Aluno aluno2;
		Aluno aluno3;
		
		Professor prof1;
		
		aluno1 = new Aluno(113113253L,"Leonardo","00000000000",new Date());
		aluno2 = new Aluno(111013243L,"Gilberto","00000000000");
		aluno3 = new Aluno(111013153L,"Tobias");
		
		prof1 = new Professor("Cruvinel","0000000000");
		prof1.setSalario(new BigDecimal(10000.64));
		
		System.out.println(aluno1);
		System.out.println(aluno2);
		System.out.println(aluno3);
		System.out.println(prof1);
		System.out.printf("O bônus do professor %s é de %f",prof1.getNome(), prof1.getSalario().multiply(BigDecimal.valueOf(Professor.BONUS)));
		
		
		
	}

}
