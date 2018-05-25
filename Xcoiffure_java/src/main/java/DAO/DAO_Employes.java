package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import exceptions.NotFoundException;
import model.Employes;

public class DAO_Employes implements IDAO_Employes {
	
	private EntityManager em;
	
	
	public DAO_Employes() {
		this.em = HibernateUtils.getEntityManager();
	}
	
	
	public Employes save(Employes obj) {
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		this.em.persist(obj);
		tx.commit();

		return obj;
	}

	
	public boolean delete(Employes obj) throws NotFoundException {
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

	
	public Employes findById(int id) {
		return this.em.find(Employes.class, id);
	}

	
	public List<Employes> findAll() {
		return this.em.createQuery("select e from Employes e", Employes.class).getResultList();
	}

}
