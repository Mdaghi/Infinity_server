package tn.esprit.infinity_server.presentation.mbeans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.github.adminfaces.starter.util.Rates;

import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.util.Exchange;

@ManagedBean
@ViewScoped
public class InterestRealTimeBean {
	
	@EJB
	FutureContractService futureContractService;
	
	private List<String> listSymbols;
	
	private List<Rates> listRates;
	
	public List<String> getListSymbols() {
		return listSymbols;
	}

	public void setListSymbols(List<String> listSymbols) {
		this.listSymbols = listSymbols;
	}

	public List<Rates> getListRates() {
		return listRates;
	}

	public void setListRates(List<Rates> listRates) {
		this.listRates = listRates;
	}

	@PostConstruct
	public void init() {
	
		
	
		
		listSymbols = new ArrayList<>();
		listRates = new ArrayList<>();
		
		listSymbols.add("usd");
		listSymbols.add("eur");
		listSymbols.add("aud");
		listSymbols.add("cad");
		listSymbols.add("cny");
		listSymbols.add("inr");
		listSymbols.add("gbp");
		listSymbols.add("jpy");
		listSymbols.add("rub");
		listSymbols.add("tnd");
		/****/
		for(String s : listSymbols)
		{
			Rates rates = new Rates();
			rates.setSymbole("favicon/"+s+".png");
			rates.setTaux(futureContractService.currencyConvertion(s));
			listRates.add(rates);
		}
	}
	
	

}
