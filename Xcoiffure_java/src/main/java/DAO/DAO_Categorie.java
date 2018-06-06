package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceptions.NotFoundException;
import fr.xcoiffure.model.Categorie;

public class DAO_Categorie implements IDAO_Categorie {
	
	private EntityManager em;
	
	
	public DAO_Categorie() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Categorie save(Categorie obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Categorie obj) throws NotFoundException {
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

	
	public Categorie findById(int id) {
		return this.em.find(Categorie.class, id);
	}

	
	public List<Categorie> findAll() {
		return this.em.createQuery("select c from Categorie c", Categorie.class).getResultList();
	}

}
