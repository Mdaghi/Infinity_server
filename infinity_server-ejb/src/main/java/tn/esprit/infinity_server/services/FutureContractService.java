package tn.esprit.infinity_server.services;


import java.util.List;


import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.infinity_server.interfaces.FutureContractServiceLocal;
import tn.esprit.infinity_server.interfaces.FutureContractServiceRemote;
import tn.esprit.infinity_server.persistence.FutureContract;
import tn.esprit.infinity_server.util.Exchange;
import tn.esprit.infinity_server.util.Future;
import tn.esprit.infinity_server.util.Information;


/**
 * Session Bean implementation class FutureContractService
 */
@Stateless
@LocalBean
public class FutureContractService implements FutureContractServiceRemote, FutureContractServiceLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	

	@Override
	public void createFutureContract(FutureContract future) {
		em.persist(future);
		
	}

	@Override
	public void updateFutureContract(FutureContract future) {
		em.merge(future);	
	}

	@Override
	public void removeFutureContract(int id) {
		FutureContract f = em.find(FutureContract.class,id);
		em.remove(f);	
	}

	@Override
	public FutureContract findFutureContractById(Integer id) {
		return null;
	}

	@Override
	public List<FutureContract> findAllFutureContract() {
		
		return null;
	}

	@Override
	public List<FutureContract> searchDynamiqueFutureContract(String name) {
		
		return null;
	}
	

	@Override
	public List<Future> showFutureData() {
		return null;	
	}
	@Override
	public List<Future> showHistoriqueDataBySymbole(String symbole) {
		return null;
	}
	
	
	
	
	public List<Future> showFutureData(String symbols) {
		
		return null;
	}
	@Override
	public Exchange currencyConvertion(String from)
	{
		
		return null;
		
	}
	@Override
	public List<Information> realTimeInfo(String info)
	{
		
		return null;
		
	}
	
	

	

}
