package DAO;

import java.util.List;

public interface IDAO <T> {
	public T save(T obj);
	
	public boolean delete(T obj);
	
	public T findById(int id);
	
	public List<T> findAll();

}
