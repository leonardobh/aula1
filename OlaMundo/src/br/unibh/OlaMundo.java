package br.unibh;

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
		
		System.out.println(aluno1);
		System.out.println(aluno2);
		System.out.println(aluno3);
		System.out.println(prof1);
		
		
		
	}

}
