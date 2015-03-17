package br.unibh.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unibh.models.Aluno;
import br.unibh.models.Professor;
import br.unibh.persistence.AlunoDAO;
import br.unibh.persistence.JDBCUtil;
import br.unibh.persistence.ProfessorDAO;


public class Testes {
	
	@Before
	public void insereNoBanco() {
		AlunoDAO aDao = new AlunoDAO();
		ProfessorDAO pDao = new ProfessorDAO();
		
		Aluno a1, a2, a3;
		
		a1 = new Aluno(null,12345L,"FOO","0123456",new Date());
		a2 = new Aluno(null,54321L,"BAR","1337",null);
		a3 = new Aluno(null,123456L,"FOOBAR","01020015",new Date());
		
		aDao.insert(a1);
		aDao.insert(a2);
		aDao.insert(a3);
		
		Professor p1,p2,p3;
		
		p1 = new Professor(null,"PROF","131313",new BigDecimal(10000.5421));
		p2 = new Professor(null,"PROF2","1414",new BigDecimal(2500.5421));
		p3 = new Professor(null,"PROF3","12013",new BigDecimal(6000.5421));
		
		pDao.insert(p1);
		pDao.insert(p2);
		pDao.insert(p3);
		
		
	}

	
	@Test
	public void testeBuscarAluno() {
		
		AlunoDAO aDao = new AlunoDAO();
		Aluno a = aDao.find(1L);
		Assert.assertEquals(a.getNome(),"FOO");
	}
	
	@Test
	public void testeBuscarProfessor() {
		ProfessorDAO pDAO = new ProfessorDAO();
		Professor p = pDAO.find(1L);
		Assert.assertEquals(p.getNome(), "PROF");
	}
	
	@Test
	public void testeInserirAluno() {
		
		AlunoDAO aDao = new AlunoDAO();
		Aluno a = new Aluno();
		a.setCpf("154545454");
		a.setNome("foo");
		a.setMatricula(123456L);
		a.setDataAniversario(new Date());
		aDao.insert(a);
		Assert.assertEquals(a.getCpf(), aDao.find("154545454").getCpf());
	}
	
	@Test
	public void testeInserirProfessor() {
		
		ProfessorDAO pDAO = new ProfessorDAO();
		Professor p = new Professor();
		p.setNome("PROF 4");
		p.setCpf("1010202030");
		p.setSalario(new BigDecimal(10000.565));
		pDAO.insert(p);
		Assert.assertEquals(pDAO.find("1010202030").getCpf(),p.getCpf());
	}
	
	@Test
	public void testeBuscarTodosAluno() {
		AlunoDAO aDao = new AlunoDAO();
		
		Assert.assertEquals(aDao.findAll().size(),aDao.countTotal());
	}
	
	@Test
	public void testeBuscarTodosProfessor() {
		ProfessorDAO pDao = new ProfessorDAO();
		
		Assert.assertEquals(pDao.findAll().size(),pDao.countTotal());
	}
	
	@Test
	public void testeAtualizarProfessor() {
		
		ProfessorDAO pDAO = new ProfessorDAO();
		Professor p = pDAO.find(1L);
		p.setNome("JOÃO SILVA");
		pDAO.update(p);
		
		Assert.assertEquals(pDAO.find(1L).getNome(),p.getNome());
	}
	
	@Test
	public void testeAtualizarAluno() {
		
		AlunoDAO aDao = new AlunoDAO();
		Aluno a = aDao.find(1L);
		a.setNome("JOAO ALUNO");
		aDao.update(a);
		
		Assert.assertEquals(aDao.find(1L).getNome(),a.getNome());
	}
	
	@Test
	public void testeDeletarAluno() {
		AlunoDAO aDao = new AlunoDAO();
		aDao.delete(aDao.find(1L));
		Assert.assertEquals(aDao.find(1L), null);
	}
	
	@Test
	public void testeDeletarProfessor() {
		ProfessorDAO pDao = new ProfessorDAO();
		pDao.delete(pDao.find(1L));
		Assert.assertEquals(pDao.find(1L),null);
	}
	
	
	@After()
	public void limpaBanco() {
		
		AlunoDAO aDAO = new AlunoDAO();
		aDAO.clean();
		ProfessorDAO pDAO = new ProfessorDAO();
		pDAO.clean();
	}

	
	

}
