package br.unibh.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unibh.models.Professor;
import br.unibh.models.Professor;


public class ProfessorDAO implements DAO<Professor,Long>{

	public Professor find(Long id) {
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("select * from tb_professor where id = ?");
			
			pstm.setLong(1, id);
			ResultSet rs = pstm.executeQuery();
			Professor professor = null;
			
			if(rs.next()) {
				professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professor.setId(rs.getLong("id"));
				professor.setSalario(rs.getBigDecimal("salario"));

			}
			
			JDBCUtil.closeConnection();
			
			return professor;
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
			
		// TODO Auto-generated method stub
		return null;
		
	}
	
	public Professor find(String cpf) {
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("select * from tb_professor where cpf = ?");
			
			pstm.setString(1, cpf);
			ResultSet rs = pstm.executeQuery();
			Professor professor = null;
			
			if(rs.next()) {
				professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professor.setId(rs.getLong("id"));
				professor.setSalario(rs.getBigDecimal("salario"));

			}
			
			JDBCUtil.closeConnection();
			
			return professor;
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
			
		// TODO Auto-generated method stub
		return null;
		
	}

	public void delete(Professor t) {
		
		PreparedStatement pstm;
		try {
			pstm = JDBCUtil.getConnection()
					.prepareStatement("delete from tb_professor where id = ?");
			pstm.setLong(1, t.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	
	}

	public void insert(Professor t) {
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("insert into tb_professor(nome, "
						+ "cpf, salario) values(?,?,?)");

			pstm.setString(1, t.getNome());
			pstm.setString(2,t.getCpf());
			pstm.setBigDecimal(3, t.getSalario());
			pstm.executeUpdate();
			JDBCUtil.closeConnection();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}

	public void update(Professor t) {
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("update tb_professor set nome = ?, salario = ? "
						+ "	where id = ?");

			pstm.setString(1, t.getNome());
			pstm.setBigDecimal(2,t.getSalario());
			pstm.setLong(3,t.getId());
			pstm.executeUpdate();
			JDBCUtil.closeConnection();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}

	public List<Professor> findAll() {
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from tb_professor");
			
			List<Professor> listaProfessor = new ArrayList<Professor>();
			
			while(result.next()){
				Professor professor = new Professor();
				professor.setId(result.getLong("id"));
				professor.setNome(result.getString("nome"));
				professor.setCpf(result.getString("cpf"));
				professor.setSalario(result.getBigDecimal("salario"));
				listaProfessor.add(professor);
			}

			JDBCUtil.closeConnection();
			
			return listaProfessor;
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}

		
		return null;
		
		
	}
	
	
	public int countTotal() {
		
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
					.prepareStatement("select count(*) from tb_professor");
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
	public void clean() {
		PreparedStatement pstm;
		try {
			pstm = JDBCUtil.getConnection()
					.prepareStatement("truncate tb_professor");
			
			pstm.executeUpdate();
			
			JDBCUtil.closeConnection();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		

	}

}
