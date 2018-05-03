package tn.esprit.infinity_server.presentation.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.github.adminfaces.starter.util.futureContractDataTable;

import tn.esprit.infinity_server.persistence.FutureContract;
import tn.esprit.infinity_server.persistence.Symbole;
import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.services.SymboleService;
import tn.esprit.infinity_server.util.Future;

@ManagedBean
@ViewScoped
public class ManageFutureBean {

	@EJB
	SymboleService symboleService;
	@EJB
	FutureContractService futureContractService;
	/***********/
	private List<Symbole> listSymbole;

	private List<FutureContract> listFutureContract;

	private List<futureContractDataTable> listContractDataTable;

	private String search;

	private futureContractDataTable futureContract;

	private List<String> listNameSymbole;

	private String name;

	private String price;

	private String size;

	private Date date;
	
	private int id;

	

	@PostConstruct
	public void init() {
		listNameSymbole = new ArrayList<String>();
		initData();
	}

	public List<Symbole> getListSymbole() {
		return listSymbole;
	}

	public void setListSymbole(List<Symbole> listSymbole) {
		this.listSymbole = listSymbole;
	}

	public List<futureContractDataTable> getListContractDataTable() {
		return listContractDataTable;
	}

	public void setListContractDataTable(List<futureContractDataTable> listContractDataTable) {
		this.listContractDataTable = listContractDataTable;
	}

	public List<FutureContract> getListFutureContract() {
		return listFutureContract;
	}

	public void setListFutureContract(List<FutureContract> listFutureContract) {
		this.listFutureContract = listFutureContract;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public futureContractDataTable getFutureContract() {
		return futureContract;
	}

	public List<String> getListNameSymbole() {

		this.listNameSymbole = new ArrayList<String>();
		for (Symbole s : symboleService.findAllSymbole()) {
			listNameSymbole.add(s.getName());
		}
		return listNameSymbole;
	}

	public void setListNameSymbole(List<String> listNameSymbole) {
		this.listNameSymbole = listNameSymbole;
	}

	public void setFutureContract(futureContractDataTable futureContract) {
		this.futureContract = futureContract;
		FutureContract future = futureContractService.findFutureContractById(futureContract.getId());
		List<Future> lst = futureContractService.showFutureData(future.getName());
		/***/
		this.futureContract.setId(future.getId());
		this.futureContract.setSymbol(future.getName());
		this.futureContract.setDateMaturite(future.getDateMaturite());
		this.futureContract.setMaturityPrice(future.getMaturityPrice());
		this.futureContract.setSize(future.getSize());
		/***/
		Double currentP = Double.parseDouble(lst.get(0).getLastPrice());
		Double maturityP = futureContract.getMaturityPrice();
		Double changePrice = currentP - maturityP;
		Double changeP = (changePrice * 100) / (Double) currentP;

		this.futureContract.setNetChange(changePrice + "");
		this.futureContract.setPercentChange(String.format("%.2f", changeP));
		this.futureContract.setGain(String.format("%.2f", (futureContract.getSize() * changePrice)));
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/************* function ****************/

	public void initData() {
		name = "";
		price = "";
		size = "";
		listContractDataTable = new ArrayList<>();
		listFutureContract = new ArrayList<>();
		listSymbole = symboleService.findAllSymbole();

		List<FutureContract> lst = futureContractService.findAllFutureContract();
		for (FutureContract futureContract : lst) {
			futureContractDataTable futureContractTw = new futureContractDataTable();
			futureContractTw.setId(futureContract.getId());
			futureContractTw.setSymbol(futureContract.getName());
			futureContractTw.setDateMaturite(futureContract.getDateMaturite());
			futureContractTw.setMaturityPrice(futureContract.getMaturityPrice());
			futureContractTw.setSize(futureContract.getSize());
			/**************/
			listContractDataTable.add(futureContractTw);
		}
	}

	public void handleKeyEvent() {
		listContractDataTable.clear();
		listContractDataTable = new ArrayList<>();
		if (search == null || search.equals("")) {
			search = "";
			List<FutureContract> lst = futureContractService.findAllFutureContract();
			for (FutureContract futureContract : lst) {
				futureContractDataTable futureContractTw = new futureContractDataTable();
				futureContractTw.setId(futureContract.getId());
				futureContractTw.setSymbol(futureContract.getName());
				futureContractTw.setDateMaturite(futureContract.getDateMaturite());
				futureContractTw.setMaturityPrice(futureContract.getMaturityPrice());
				futureContractTw.setSize(futureContract.getSize());
				/**************/
				listContractDataTable.add(futureContractTw);
			}
		} else {
			List<FutureContract> lst = futureContractService.searchDynamiqueFutureContract(search);
			for (FutureContract futureContract : lst) {
				futureContractDataTable futureContractTw = new futureContractDataTable();
				futureContractTw.setId(futureContract.getId());
				futureContractTw.setSymbol(futureContract.getName());
				futureContractTw.setDateMaturite(futureContract.getDateMaturite());
				futureContractTw.setMaturityPrice(futureContract.getMaturityPrice());
				futureContractTw.setSize(futureContract.getSize());
				/**************/
				listContractDataTable.add(futureContractTw);

			}
		}
	}

	public void delete(int id) {
		futureContractService.removeFutureContract(id);
		search = "";
		initData();
	}

	public void ajouter() {
		Symbole symbole = symboleService.getSymboleByName(name);
		FutureContract futureContract = new FutureContract();
		/**************************/
		futureContract.setDateMaturite(date);
		futureContract.setMaturityPrice(Double.parseDouble(price));
		futureContract.setSize(Integer.parseInt(size));
		futureContract.setName(name);
		futureContract.setSymbole(symbole);
		/**************************/
		futureContractService.createFutureContract(futureContract);
		name = "";
		price = "";
		size = "";
		date = new Date();

	}
	
	public void selectupdate(futureContractDataTable future){
		name = future.getSymbol();
		price = future.getMaturityPrice()+"";
		date = future.getDateMaturite();
		size = future.getSize()+"";
		id= future.getId();
	}
	public void update() {
		
		Symbole symbole = symboleService.getSymboleByName(name);
		FutureContract futureContract = futureContractService.findFutureContractById(id);
		/**************************/
		futureContract.setDateMaturite(date);
		futureContract.setMaturityPrice(Double.parseDouble(price));
		futureContract.setSize(Integer.parseInt(size));
		futureContract.setName(name);
		futureContract.setSymbole(symbole);
		/**************************/
		futureContractService.updateFutureContract(futureContract);
		name = "";
		price = "";
		size = "";
		date = new Date();

	}

	public void speculation(int id) {

		FutureContract future = futureContractService.findFutureContractById(id);
		List<Future> lst = futureContractService.showFutureData(future.getName());
		/***/
		futureContract.setId(future.getId());
		futureContract.setSymbol(future.getName());
		futureContract.setDateMaturite(future.getDateMaturite());
		futureContract.setMaturityPrice(future.getMaturityPrice());
		futureContract.setSize(future.getSize());
		/***/
		Double currentP = Double.parseDouble(lst.get(0).getLastPrice());
		Double maturityP = futureContract.getMaturityPrice();
		Double changePrice = currentP - maturityP;
		Double changeP = (changePrice * 100) / (Double) currentP;

		futureContract.setNetChange(changePrice + "");
		futureContract.setNetChange(String.format("%.2f", changeP));
		futureContract.setGain(String.format("%.2f", (futureContract.getSize() * changePrice)));

		/***/
	}

}
