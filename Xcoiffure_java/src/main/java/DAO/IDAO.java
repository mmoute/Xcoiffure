package DAO;

import java.util.List;

import exceptions.NotFoundException;

public interface IDAO <T> {
	public T save(T obj);
	
	public boolean delete(T obj) throws NotFoundException ;
	
	public T findById(int id);
	
	public List<T> findAll();

}
