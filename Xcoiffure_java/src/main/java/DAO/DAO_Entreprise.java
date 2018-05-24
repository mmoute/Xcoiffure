package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Entreprise;

public class DAO_Entreprise implements IDAO_Entreprise {
	
private EntityManager em;
	
	
	public DAO_Entreprise() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Entreprise save(Entreprise obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Entreprise obj) {
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

	
	public Entreprise findById(int id) {
		return this.em.find(Entreprise.class, id);
	}

	
	public List<Entreprise> findAll() {
		return this.em.createQuery("select e from Entreprise e", Entreprise.class).getResultList();
	}

}
