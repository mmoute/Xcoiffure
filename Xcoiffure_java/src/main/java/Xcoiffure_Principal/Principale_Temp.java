package Xcoiffure_Principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principale_Temp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NomPersistenceUnit");
		EntityManager em = emf.createEntityManager();
	
		em.close();
		emf.close();
	}

}
