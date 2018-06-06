package fr.Xcoiffure.dao.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.Xcoiffure.config.jpa.JpaConfig;
import fr.xcoiffure.model.Client;
import fr.xcoiffure.model.Rdv;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class })
public class IDAORdvTest {

	@Autowired(required = false)
	private IDAORdv daoRdv;
	@Autowired(required = false)
	private IDAOClient daoClient;

	@Test
	public void testIdaoRdvExist() {
		assertNotNull(daoRdv);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testfindByClientNomContainsExist() {

		Client C1 = new Client();
		C1.setNom("Maurice");
		C1.setPrenom("île");
		daoClient.save(C1);

		Rdv myRdv = new Rdv();

		myRdv.setClient(C1);

		assertEquals(0, myRdv.getId());
		daoRdv.save(myRdv);
		assertNotEquals(0, myRdv.getId());

	}
}
