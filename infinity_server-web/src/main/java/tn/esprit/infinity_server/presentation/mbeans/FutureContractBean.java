package tn.esprit.infinity_server.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.infinity_server.persistence.FutureContract;
import tn.esprit.infinity_server.persistence.Symbole;
import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.services.SymboleService;
import tn.esprit.infinity_server.util.Future;

@ManagedBean
@ViewScoped
public class FutureContractBean {
		
	@EJB
	SymboleService symboleService;

	@EJB
	FutureContractService futureContractService;

	private List<Symbole> listSymbole;

	private String search;

	private Symbole symbole;
	
	private FutureContract future;

	public FutureContract getFuture() {
		return future;
	}

	public void setFuture(FutureContract future) {
		this.future = future;
	}

	private String name;

	private String url;

	private String exist;

	private boolean disable;

	private String company;

	public String getExist() {
		return exist;
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@PostConstruct
	public void init() {
		search = "";
		listSymbole = new ArrayList<>();
		listSymbole = symboleService.searchDynamiqueSymbole("");
	}

	public void handleKeyEvent() {
		listSymbole.clear();
		listSymbole = new ArrayList<>();
		if (search == null || search.equals("")) {
			search = "";
			listSymbole = symboleService.findAllSymbole();
		} else
			listSymbole = symboleService.searchDynamiqueSymbole(search);
	}

	public void delete(int id) {
		symboleService.removeSymbole(id);
		listSymbole.clear();
		listSymbole = new ArrayList<>();
		search = "";
		listSymbole = symboleService.findAllSymbole();
	}

	public void handleKeyNameEvent() {
		company = "";
		disable = true;
		if (name == null || name.equals("")) {
			url = "Symbol field is empty";
			return;
		}

		if (!symboleService.checkUniqueSymbole(name)) {
			url = "Symbol already exsit";
			return;
		}
		List<Future> lst = futureContractService.showFutureData(name);
		if (lst != null) {
			url = "https://marketdata.websol.barchart.com"
					+ "/getQuote.json?apikey=3b317303ebe00e5e3d59400561b0a17d&symbols=" + name;
			company = lst.get(0).getName();
			disable = false;
		} else {
			url = "invalid symbole ✕";	
		}
	}
	public void ajouter()
	{
		Symbole symbole = new Symbole();
		symbole.setName(name);
		symbole.setUrl(url);
		symboleService.createSymbole(symbole);
		name="";
		url="";
	}

	public List<Symbole> getListSymbole() {
		return listSymbole;
	}

	public void setListSymbole(List<Symbole> listSymbole) {
		this.listSymbole = listSymbole;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Symbole getSymbole() {
		return symbole;
	}

	public void setSymbole(Symbole symbole) {
		this.symbole = symbole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
