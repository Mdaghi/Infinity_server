package tn.esprit.infinity_server.presentation.mbeans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.github.adminfaces.starter.util.SymbolNews;

import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.util.Information;


@ManagedBean
@ViewScoped
public class InformationBean{
	
	@EJB
	FutureContractService futureContractService;
	
	private List<String> stringSymbols;
	
	public List<String> getStringSymbols() {
		return stringSymbols;
	}

	public void setStringSymbols(List<String> stringSymbols) {
		this.stringSymbols = stringSymbols;
	}
	private List<SymbolNews> listSymbols;
	
	private List<Information> listInformation;
	
	
	public List<SymbolNews> getListSymbols() {
		return listSymbols;
	}

	public void setListSymbols(List<SymbolNews> listSymbols) {
		this.listSymbols = listSymbols;
	}

	public List<Information> getListInformation() {
		return listInformation;
	}

	public void setListInformation(List<Information> listInformation) {
		this.listInformation = listInformation;
	}

	@PostConstruct
	public void init() {

		listSymbols = new ArrayList<>();
		listInformation = new ArrayList<>();
		stringSymbols = new ArrayList<>();
		/**/
		
		stringSymbols.add("bloomberg");
		stringSymbols.add("cnbc");
		stringSymbols.add("info-money");
		stringSymbols.add("crypto-coins-news");
		stringSymbols.add("australian-financial-review");
		stringSymbols.add("nbc-news");
		stringSymbols.add("the-wall-street-journal");
		stringSymbols.add("national-geographic");
		
		
		
		
		
		
		for(String s : stringSymbols)
		{
			SymbolNews news = new SymbolNews();
			news.setPath("favicon/"+s+".png");
			news.setSymbol(s);
			listSymbols.add(news);
		}
		
		/**/
		listInformation = futureContractService.realTimeInfo("bloomberg");

	}
	public void initDataBySymbol(String symbol)
	{
		System.out.println(symbol);
		listInformation.clear();
		listInformation = new ArrayList<>();
		listInformation = futureContractService.realTimeInfo(symbol);
	}
	public void hello()
	{
		System.err.println("a3tih el 7ess");
	}
	
	

}
