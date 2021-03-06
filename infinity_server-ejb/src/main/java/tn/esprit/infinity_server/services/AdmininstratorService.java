package tn.esprit.infinity_server.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infinity_server.interfaces.AdmininstratorLocal;
import tn.esprit.infinity_server.interfaces.AdmininstratorRemote;
import tn.esprit.infinity_server.persistence.Administrator;


/**
 * Session Bean implementation class AdmininstratorService
 */
@Stateless
@LocalBean
public class AdmininstratorService implements AdmininstratorRemote, AdmininstratorLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	

	@Override
	public void CreateAdmin(Administrator admin) {
		em.persist(admin);
		
	}

	
	

}
