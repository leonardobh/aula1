package br.unibh.persistence;

import java.util.List;

public interface DAO<T,K> {

	T find(K id);
	void delete(T t);
	void insert(T t);
	void update(T t);
	List<T> findAll();
	
	
}
