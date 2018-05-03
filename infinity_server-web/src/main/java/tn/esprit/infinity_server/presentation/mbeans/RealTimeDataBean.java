package tn.esprit.infinity_server.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.services.SymboleService;
import tn.esprit.infinity_server.util.Future;

@ManagedBean
@ViewScoped
public class RealTimeDataBean {

	@EJB
	FutureContractService futureContractservice;
	
	@EJB
	SymboleService symboleService;


	private List<Future> listFuture;
	
	private String search;
	

	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	@PostConstruct
	public void init() {
		listFuture = new ArrayList<>();
		String listSymbole = symboleService.allListSymbole();
		listFuture = futureContractservice.showFutureData(listSymbole);		
	}
	
	
	public List<Future> getListFuture() {
		return listFuture;
	}


	public void setListFuture(List<Future> listFuture) {
		this.listFuture = listFuture;
	}

}
