package fr.Xcoiffure.dao.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.Xcoiffure.config.jpa.JpaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ JpaConfig.class })
public class IDAORdvTest {
	
	@Autowired(required=false)
    private IDAORdv daoRdv;
    
    
    @Test
    public void testExists() {
        assertNotNull(daoRdv);
    }

}
