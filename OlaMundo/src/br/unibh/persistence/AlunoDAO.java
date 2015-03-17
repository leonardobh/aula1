package br.unibh.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unibh.models.Aluno;


public class AlunoDAO implements DAO<Aluno,Long>{

	public Aluno find(Long id) {
		
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("select * from tb_aluno where id = ?");
			
			pstm.setLong(1, id);
			ResultSet rs = pstm.executeQuery();
			Aluno aluno = null;
			
			if(rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setId(rs.getLong("id"));
				aluno.setDataAniversario(rs.getDate("data_aniversario"));
			}
			
			return aluno;
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
			
		// TODO Auto-generated method stub
		return null;
	}
	
	public Aluno find(String cpf) {
		
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("select * from tb_aluno where cpf = ?");
			
			pstm.setString(1, cpf);
			ResultSet rs = pstm.executeQuery();
			Aluno aluno = null;
			
			if(rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getLong("matricula"));
				aluno.setId(rs.getLong("id"));
				aluno.setDataAniversario(rs.getDate("data_aniversario"));
			}
			
			return aluno;
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
			
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public void delete(Aluno t) {
		
		PreparedStatement pstm;
		try {
			pstm = JDBCUtil.getConnection()
					.prepareStatement("delete from tb_aluno where id = ?");
			pstm.setLong(1, t.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		
	}

	public void insert(Aluno t) {
		
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("insert into tb_aluno(matricula, nome, "
						+ "cpf, data_aniversario) values(?,?,?,?)");
			
			pstm.setLong(1,t.getMatricula());
			pstm.setString(2, t.getNome());
			pstm.setString(3,t.getCpf());
			if(t.getDataAniversario() !=null) {
				pstm.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(t.getDataAniversario()));
			}else {
				pstm.setNull(4, Types.NULL);
			}
			pstm.executeUpdate();
			
			JDBCUtil.closeConnection();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

	public void update(Aluno t) {
	
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
				.prepareStatement("update tb_aluno set matricula = ? , nome = ? , "
						+ "data_aniversario = ? where id = ?");
			
			pstm.setLong(1,t.getMatricula());
			pstm.setString(2, t.getNome());
			if(t.getDataAniversario() !=null) {
				pstm.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(t.getDataAniversario()));
			}else {
				pstm.setNull(3, Types.NULL);
			}
			pstm.setLong(4,t.getId());
			pstm.executeUpdate();
			
			JDBCUtil.closeConnection();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
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

			JDBCUtil.closeConnection();
			
			return listaAluno;
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}

		
		return null;
	}
	
	public int countTotal() {
		
		try {
			PreparedStatement pstm = JDBCUtil.getConnection()
					.prepareStatement("select count(*) from tb_aluno");
			
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
					.prepareStatement("truncate tb_aluno");
			
			pstm.executeUpdate();
			
			JDBCUtil.closeConnection();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		

	}


}
