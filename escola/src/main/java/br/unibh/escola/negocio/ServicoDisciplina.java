package br.unibh.escola.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;

@Stateless
@LocalBean
public class ServicoDisciplina implements DAO<Long,Disciplina> {

	@Inject
	EntityManager em;
	
	@Inject
	Logger log;
	
	@Override
	public Disciplina insert(Disciplina type) throws Exception {
		
		type.setProfessor(em.getReference(Professor.class, type.getProfessor().getId()));
		type.setSala((em.getReference(Sala.class, type.getSala().getId())));
		List<Aluno> atachados = new ArrayList<Aluno>();
		for(Aluno aluno : type.getAlunos()) {
			 atachados.add(em.getReference(Aluno.class, aluno.getId()));
		}
		type.setAlunos(atachados);
		
		log.info("Persistindo "+type);
		em.persist(type);
		return type;
	}

	@Override
	public Disciplina update(Disciplina type) throws Exception {
		log.info("Atualizando "+type);
		return em.merge(type);
	}

	@Override
	public void delete(Disciplina type) throws Exception {
		log.info("Deletando "+type);
		type = em.find(Disciplina.class, type.getId());
		type.getAlunos().clear();
		em.remove(type);
	}

	@Override
	public Disciplina find(Long key) throws Exception {
		log.info("Encontrando disciplina "+key);
		return em.find(Disciplina.class, key);
	}
	
	public Disciplina findComAlunos(Long key) throws Exception {
		log.info("Encontrando disciplina "+ key +" com alunos");
        Query query = em.createQuery("select d from Disciplina d join fetch d.alunos where d.id = :id")
        		.setParameter("id", key);
        return (Disciplina) query.getSingleResult();
	}

	@Override
	public List<Disciplina> findAll() throws Exception {
		log.info("Encontrando todas as Disciplinas");
		return em.createQuery(" from Disciplina").getResultList();
	}

	@Override
	public List<Disciplina> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Disciplina> findByNomeOuCurso(String nome,String curso) throws Exception {
		log.info("Encontrando todos as Disciplinas com name "+nome + " e curso "+curso);
		return em.createNamedQuery("Disciplina.findByNomeOuCurso")
				.setParameter("nome", "%"+nome+"%")
				.setParameter("curso", "%"+curso+"%")
				.getResultList();
	}	
	
	
	

}
