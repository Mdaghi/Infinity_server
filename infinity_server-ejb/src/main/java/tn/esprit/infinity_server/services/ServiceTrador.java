package tn.esprit.infinity_server.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infinity_server.interfaces.TradorLocal;
import tn.esprit.infinity_server.interfaces.TradorRemote;
import tn.esprit.infinity_server.persistence.Trader;

/**
 * Session Bean implementation class ServiceTrador
 */
@Stateless
@LocalBean
public class ServiceTrador implements TradorRemote, TradorLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ServiceTrador() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void CreateTrader(Trader trader) {
		em.persist(trader);
	}

}
