package br.unibh.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unibh.models.Aluno;


public class AlunoDAO implements DAO<Aluno,Long>{

	public Aluno find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	public void insert(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	public void update(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	public List<Aluno> findAll() {
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from tb_aluno");
			
			List<Aluno> listaAluno = new ArrayList<Aluno>();
			
			while(result.next()){
				Aluno aluno = new Aluno();
				aluno.setId(result.getLong("id"));
				aluno.setNome(result.getString("nome"));
				aluno.setCpf(result.getString("cpf"));
				aluno.setMatricula(result.getLong("matricula"));
				aluno.setDataAniversario(result.getDate("data_aniversario"));
				listaAluno.add(aluno);
			}
			
			return listaAluno;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



}
