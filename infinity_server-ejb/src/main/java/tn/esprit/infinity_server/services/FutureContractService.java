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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFutureContract(FutureContract future) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFutureContract(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FutureContract findFutureContractById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FutureContract> findAllFutureContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FutureContract> searchDynamiqueFutureContract(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Future> showFutureData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Future> showHistoriqueDataBySymbole(String symbole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Future> showFutureData(String symbols) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exchange currencyConvertion(String from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Information> realTimeInfo(String info) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

	

}
