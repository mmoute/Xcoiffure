package DAO;
import java.util.List;
import exceptions.NotFoundException;


public interface DAO<T> {
		
		public T save(T obj);
		
		public T modifier(T obj);
		
		public boolean delete(T obj);
		
		public T find(String nom) throws NotFoundException;
		
		public List<T> findAll();

}
