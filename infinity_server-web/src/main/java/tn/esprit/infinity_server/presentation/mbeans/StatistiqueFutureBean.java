package tn.esprit.infinity_server.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import tn.esprit.infinity_server.persistence.Symbole;
import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.services.SymboleService;
import tn.esprit.infinity_server.util.Future;


@ManagedBean
@ViewScoped
public class StatistiqueFutureBean {

	@EJB
	FutureContractService futureContractservice;
	@EJB
	SymboleService symboleService;

	private List<Symbole> listSymbole;
	private List<ModelStatistic> listModel;
	private String search;

	public static final String VOLUME = "Volume";
	public static final String DATES = "Dates";

	@PostConstruct
	public void init() {
		search = "";
		initData();
	}

	/*************************************************************/
	public void initData() {
		listModel = new ArrayList<>();
		listSymbole = new ArrayList<>();
		listSymbole = symboleService.findAllSymbole();
		for (Symbole s : listSymbole) {
			symboleDataInit(s.getName());
		}
	}

	public void symboleDataInit(String symbole) {
		LineChartModel lineModelVolume = new LineChartModel();
		lineModelVolume.setTitle("Transaction per a Day " + symbole);
		lineModelVolume.setZoom(true);
		lineModelVolume.getAxis(AxisType.Y).setLabel(VOLUME);
		DateAxis axis = new DateAxis(DATES);
		axis.setTickAngle(-90);
		lineModelVolume.getAxes().put(AxisType.X, axis);

		LineChartModel lineModelPrice = new LineChartModel();
		lineModelPrice.setTitle("Price per a Day " + symbole);
		lineModelPrice.setZoom(true);
		lineModelPrice.getAxis(AxisType.Y).setLabel("Price");
		DateAxis axisD = new DateAxis(DATES);
		axisD.setTickAngle(-90);
		lineModelPrice.getAxes().put(AxisType.X, axisD);

		LineChartSeries serieVolume = new LineChartSeries();
		LineChartSeries serieClose = new LineChartSeries();
		serieVolume.setLabel(VOLUME);
		serieClose.setLabel("Price");

		List<Future> lstFuture = futureContractservice.showHistoriqueDataBySymbole(symbole);
		for (Future future : lstFuture) {
			serieVolume.set(future.getTradeTimestamp(), Double.parseDouble(future.getVolume()));
			serieClose.set(future.getTradeTimestamp(), Double.parseDouble(future.getClose()));
		}
		lineModelVolume.addSeries(serieVolume);
		lineModelVolume.setSeriesColors("212F3C,FFCC33,F74A4A,F52F2F,A30303");
		lineModelPrice.addSeries(serieClose);
		lineModelPrice.setSeriesColors("c0392b,58BA27,F74A4A,F52F2F,A30303");

		ModelStatistic model = new ModelStatistic();
		model.setLineModelPrice(lineModelPrice);
		model.setLineModelVolume(lineModelVolume);
		model.setPriceTitle(symbole);
		listModel.add(model);

	}

	/*************************************************************/
	public List<Symbole> getListSymbole() {
		return listSymbole;
	}

	public void setListSymbole(List<Symbole> listSymbole) {
		this.listSymbole = listSymbole;
	}

	public List<ModelStatistic> getListModel() {
		return listModel;
	}

	public void setListModel(List<ModelStatistic> listModel) {
		this.listModel = listModel;
	}

	public void handleKeyEvent() {
		listModel.clear();
		listSymbole.clear();
		listModel = new ArrayList<>();
		listSymbole = new ArrayList<>();
		if (search.equals(""))
			initData();
		else {
			listSymbole = symboleService.searchDynamiqueSymbole(search);
			for (Symbole s : listSymbole) {
				symboleDataInit(s.getName());
			}
		}

	}
	
	
	public class ModelStatistic {

		private LineChartModel lineModelVolume;
		private LineChartModel lineModelPrice;
		private String priceTitle;
		private String volumeTitle;

		public String getPriceTitle() {
			return priceTitle;
		}

		public void setPriceTitle(String priceTitle) {
			this.priceTitle = priceTitle;
		}

		public String getVolumeTitle() {
			return volumeTitle;
		}

		public void setVolumeTitle(String volumeTitle) {
			this.volumeTitle = volumeTitle;
		}

		public LineChartModel getLineModelVolume() {
			return lineModelVolume;
		}

		public void setLineModelVolume(LineChartModel lineModelVolume) {
			this.lineModelVolume = lineModelVolume;
		}

		public LineChartModel getLineModelPrice() {
			return lineModelPrice;
		}

		public void setLineModelPrice(LineChartModel lineModelPrice) {
			this.lineModelPrice = lineModelPrice;
		}
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
