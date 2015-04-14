package br.unibh.escola.negocio;

import java.util.List;

public interface DAO<K,T> {
	
	T insert(T type) throws Exception;
	T update(T type) throws Exception;
	void delete(T type) throws Exception;
	T find(K key) throws Exception;
	List<T> findAll()  throws Exception;
	List<T> findByName(String name)  throws Exception;


}
