package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Rdv;

public class DAO_Rdv implements IDAO_Rdv {

	
	private EntityManager em;
	
	
	public DAO_Rdv() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Rdv save(Rdv obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Rdv obj) {
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

	
	public Rdv findById(int id) {
		return this.em.find(Rdv.class, id);
	}

	
	public List<Rdv> findAll() {
		return this.em.createQuery("select r from Rdv r", Rdv.class).getResultList();
	}


}
