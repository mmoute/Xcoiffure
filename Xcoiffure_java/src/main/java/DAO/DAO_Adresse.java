package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceptions.NotFoundException;
import model.Adresse;

public class DAO_Adresse implements IDAO_Adresse {
	
private EntityManager em;
	
	
	public DAO_Adresse() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Adresse save(Adresse obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Adresse obj) throws NotFoundException {
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

	
	public Adresse findById(int id) {
		return this.em.find(Adresse.class, id);
	}

	
	public List<Adresse> findAll() {
		return this.em.createQuery("select a from Adresse a", Adresse.class).getResultList();
	}

}
