package br.unibh.escola.negocio;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.escola.entidades.Sala;

@Stateless
@LocalBean
public class ServicoSala implements DAO<Long,Sala> {
	
	@Inject
	EntityManager em;
	
	@Inject
	Logger log;

	@Override
	public Sala insert(Sala type) throws Exception {
		log.info("Persistindo "+type);
		em.persist(type);
		return type;
	}

	@Override
	public Sala update(Sala type) throws Exception {
		log.info("Atualizando "+type);
		return em.merge(type);
	}

	@Override
	public void delete(Sala type) throws Exception {
		log.info("Deletando "+type);
		em.remove(em.getReference(Sala.class, type.getId()));
	}

	@Override
	public Sala find(Long key) throws Exception {
		log.info("Encontrando sala "+key);
		return em.find(Sala.class, key);
	}

	@Override
	public List<Sala> findAll() throws Exception {
		log.info("Encontrando todas os salas");
		return em.createQuery(" from Sala").getResultList();
	}

	@Override
	public List<Sala> findByName(String name) throws Exception {
		return null;
	}
	
	public List<Sala> findByCapacidade(int capacidade) throws Exception {
		log.info("Encontrando todos as salas com capacidade "+capacidade);
		return em.createNamedQuery("Sala.findByCapacidade")
				.setParameter("capacidade", capacidade).getResultList();
	}
	
	

}
