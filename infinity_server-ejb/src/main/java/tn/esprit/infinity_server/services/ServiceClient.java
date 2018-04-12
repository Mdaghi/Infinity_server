package tn.esprit.infinity_server.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infinity_server.interfaces.ClientRemote;
import tn.esprit.infinity_server.persistence.Client;

@Stateless
public class ServiceClient implements ClientRemote {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	
	@Override
	public void updateClient(Client client) {
		em.merge(client);
	}
	
}
