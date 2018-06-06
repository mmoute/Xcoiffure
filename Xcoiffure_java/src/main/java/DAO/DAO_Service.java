package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceptions.NotFoundException;
import fr.xcoiffure.model.Service;

public class DAO_Service implements IDAO_Service {
	
	private EntityManager em;
	
	
	public DAO_Service() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Service save(Service obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Service obj) throws NotFoundException {
		EntityTransaction tx = this.em.getTransaction();

		try {
			tx.begin();
			this.em.remove(this.em.merge(obj));
			tx.commit();

			return true;
		}

		catch (Exception ex) {
			tx.rollback();

			return false;
		}
	}

	
	public Service findById(int id) {
		return this.em.find(Service.class, id);
	}

	
	public List<Service> findAll() {
		return this.em.createQuery("select s from Service s", Service.class).getResultList();
	}

}
