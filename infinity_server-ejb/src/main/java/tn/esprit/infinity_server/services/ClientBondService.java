package tn.esprit.infinity_server.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;

import tn.esprit.infinity_server.interfaces.ClientBondMangeRemote;
import tn.esprit.infinity_server.persistence.Bond;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.Trader;

@Stateless
public class ClientBondService implements ClientBondMangeRemote{
    
	@PersistenceContext(unitName="infinity_server-ejb")
	EntityManager em ;
	@Override 
	public void selectTrador(int idclient,int idTrader) {
		//em.persist(em.find(User u,int idTrader));
		Trader trader =em.find(Trader.class,idTrader) ;
		
		Client client=em.find(Client.class , idclient);
		client.setTrador(trader);
	
	}

	@Override
	public void removeTrador() {
		
		
	}

	@Override
	public void demandBond(Bond b) {
		// TODO Auto-generated method stub
		
	}

}
