package tn.esprit.infinity_server.presentation.mbeans;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import com.github.adminfaces.starter.util.futureContractDataTable;

import tn.esprit.infinity_server.persistence.FutureContract;
import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.util.Future;
import tn.esprit.infinity_server.util.FutureJson;


@ManagedBean
@ViewScoped
public class FutureGainBean {
	
	@EJB
	FutureContractService futureContractService;
	
	List<futureContractDataTable> listFuture = new ArrayList<>();
	public List<futureContractDataTable> getLst() {
		return listFuture;
	}
	public void setLst(List<futureContractDataTable> lst) {
		this.listFuture = lst;
	}
	@PostConstruct
	public void init() {
		
	buildData();
		
	}
	public void buildData(){
		listFuture = new ArrayList<>();
		List<FutureContract> lst = futureContractService.findAllFutureContract();
		for (FutureContract futureContract : lst) {
			futureContractDataTable futureContractTw = new futureContractDataTable();
			futureContractTw.setId(futureContract.getId());
			futureContractTw.setSymbol(futureContract.getName());
			futureContractTw.setDateMaturite(futureContract.getDateMaturite());
			futureContractTw.setMaturityPrice(futureContract.getMaturityPrice());
			futureContractTw.setSize(futureContract.getSize());
			/***/
			FutureJson futureJson = new FutureJson();
			List<Future> lstfuture = futureJson.showFutureData(futureContract.getName());
			futureContractTw.setCurrentPrice(Double.parseDouble(lstfuture.get(0).getLastPrice()));
			/**************/
			Double currentP = Double.parseDouble(lstfuture.get(0).getLastPrice());
			Double maturityP = futureContract.getMaturityPrice();
			Double changePrice = currentP - maturityP;
			Double changeP;
			futureContractTw.setNetChange(String.format("%.2f",changePrice));
			if(changePrice>0)
			{
				changeP = (changePrice*100)/(Double)currentP;
				
			}
			else
			{
				changeP = (changePrice*100)/(Double)maturityP;
			}
			futureContractTw.setPercentChange(String.format("%.2f",changeP));
			futureContractTw.setGain(String.format("%.2f",(futureContract.getSize()*changePrice)));
			listFuture.add(futureContractTw);
		}
		
		
	}
	
	

}
