package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Client;

public class DAO_Client implements IDAO_Client {
	
	private EntityManager em;
	
	
	public DAO_Client() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Client save(Client obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Client obj) {
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

	
	public Client findById(int id) {
		return this.em.find(Client.class, id);
	}

	
	public List<Client> findAll() {
		return this.em.createQuery("select c from Client c", Client.class).getResultList();
	}

}
