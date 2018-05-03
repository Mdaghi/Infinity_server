package tn.esprit.infinity_server.interfaces;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.FutureContract;
import tn.esprit.infinity_server.util.Exchange;
import tn.esprit.infinity_server.util.Future;
import tn.esprit.infinity_server.util.Information;



@Remote
public interface FutureContractServiceRemote {
	public void createFutureContract(FutureContract future);
	public void updateFutureContract(FutureContract future);
	public void removeFutureContract(int id);
	FutureContract findFutureContractById(Integer id);
	List<FutureContract> findAllFutureContract();
	public List<FutureContract> searchDynamiqueFutureContract(String name);
	public List<Future> showFutureData();
	public List<Future> showHistoriqueDataBySymbole(String symbole);
	public List<Future> showFutureData(String symbols);
	public Exchange currencyConvertion(String from);
	public List<Information> realTimeInfo(String info);
		
}
