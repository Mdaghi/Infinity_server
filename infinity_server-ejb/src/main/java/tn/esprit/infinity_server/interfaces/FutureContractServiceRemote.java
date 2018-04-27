package tn.esprit.infinity_server.interfaces;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.FutureContract;
import tn.esprit.infinity_server.util.Future;



@Remote
public interface FutureContractServiceRemote {
	public void createFutureContract(FutureContract future);
	public void updateFutureContract(FutureContract future);
	public void removeFutureContract(int id);
	FutureContract findFutureContractById(Integer id);
	List<FutureContract> findAllFutureContract();
	public List<FutureContract> searchDynamiqueFutureContract(String name);
	
		
}
