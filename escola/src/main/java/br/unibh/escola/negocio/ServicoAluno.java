package br.unibh.escola.negocio;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.escola.entidades.Aluno;

@Stateless
@LocalBean
public class ServicoAluno implements DAO<Long,Aluno> {
	
	@Inject
	EntityManager em;
	
	@Inject
	Logger log;

	@Override
	public Aluno insert(Aluno type) throws Exception {
		log.info("Persistindo "+type);
		em.persist(type);
		return type;
	}

	@Override
	public Aluno update(Aluno type) throws Exception {
		log.info("Atualizando "+type);
		return em.merge(type);
	}

	@Override
	public void delete(Aluno type) throws Exception {
		log.info("Deletando "+type);
		em.remove(em.getReference(Aluno.class, type.getId()));
	}

	@Override
	public Aluno find(Long key) throws Exception {
		log.info("Encontrando aluno "+key);
		return em.find(Aluno.class, key);
	}

	@Override
	public List<Aluno> findAll() throws Exception {
		log.info("Encontrando todos os alunos");
		return em.createQuery(" from Aluno").getResultList();
	}

	@Override
	public List<Aluno> findByName(String name) throws Exception {
		log.info("Encontrando todos os alunos com name "+name);
		return em.createNamedQuery("Aluno.findByName")
				.setParameter("nome", name+"%").getResultList();
	}
	
	

}
