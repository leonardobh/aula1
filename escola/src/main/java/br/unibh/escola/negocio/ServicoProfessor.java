package br.unibh.escola.negocio;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.escola.entidades.Professor;

@Stateless
@LocalBean
public class ServicoProfessor implements DAO<Long,Professor> {
	
	@Inject
	EntityManager em;
	
	@Inject
	Logger log;

	@Override
	public Professor insert(Professor type) throws Exception {
		log.info("Persistindo "+type);
		em.persist(type);
		return type;
	}

	@Override
	public Professor update(Professor type) throws Exception {
		log.info("Atualizando "+type);
		return em.merge(type);
	}

	@Override
	public void delete(Professor type) throws Exception {
		log.info("Deletando "+type);
		em.remove(type);
	}

	@Override
	public Professor find(Long key) throws Exception {
		log.info("Encontrando professor "+key);
		return em.find(Professor.class, key);
	}

	@Override
	public List<Professor> findAll() throws Exception {
		log.info("Encontrando todos os professores");
		return em.createQuery(" from Professor").getResultList();
	}

	@Override
	public List<Professor> findByName(String name) throws Exception {
		log.info("Encontrando todos os professores com name "+name);
		return em.createNamedQuery("Professor.findByName")
				.setParameter("nome", name+"%").getResultList();
	}
	
	

}
