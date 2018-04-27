package tn.esprit.infinity_server.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.kevinsawicki.http.HttpRequest;

import tn.esprit.infinity_server.services.FutureContractService;
import tn.esprit.infinity_server.util.Future;

@ManagedBean
@ViewScoped
public class RealTimeDataBean {

	@EJB
	FutureContractService futureContractservice;


	public static final String CLOSE = "close";
	private static final String HIGH = "high";
	private static final String LASTPRICE = "lastPrice";
	private static final String LOW = "low";
	private static final String NAME = "name";
	private static final String NETCHANGE = "netChange";
	private static final String OPEN = "open";
	private static final String PERCENTCHANGE = "percentChange";
	private static final String SYMBOL = "symbol";
	private static final String TRADE = "tradeTimestamp";
	private static final String VOLUME = "volume";

	private List<Future> listFuture;

	@PostConstruct
	public void init() {
		listFuture = new ArrayList<>();
		
	}

	public List<Future> showFutureData() {
		String response = HttpRequest.get("https://marketdata.websol.barchart.com"
				+ "/getQuote.json?apikey=5762666332e2d8a7b5374845ed4c5513&symbols="
				+ "ZC*1,IBM,GOOGL,%5EEURUSD,AMZN,AAPL,FB,NFLX,INTC,"
				+ "TGT,BAC,PIH,TSLA,BABA,F,MU,INTC,GE,TWTR,WMT,NOK,"
				+ "QQQ,WDC,ECYT,ADMP,GM,TI,SRPT,LRCX,TRXC,TSRO,CSPI," + "CASA,BB,GILD,XOM,PBR,AXP,QCOM,FIT,UAA,DAL,CVS")
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		JSONArray result = jsonObject.getJSONArray("results");
		for (int i = 0; i < result.length(); i++) {
			Future future = new Future();
			future.setRef(i + "");
			future.setClose(result.getJSONObject(i).getDouble(CLOSE) + "");
			future.setHigh(result.getJSONObject(i).getDouble(HIGH) + "");
			future.setLastPrice(result.getJSONObject(i).getDouble(LASTPRICE) + "");
			future.setLow(result.getJSONObject(i).getDouble(LOW) + "");
			future.setName(result.getJSONObject(i).getString(NAME));
			future.setNetChange(result.getJSONObject(i).getDouble(NETCHANGE) + "");
			future.setOpen(result.getJSONObject(i).getDouble(OPEN) + "");
			future.setPercentChange(result.getJSONObject(i).getDouble(PERCENTCHANGE) + "");
			future.setSymbol(result.getJSONObject(i).getString(SYMBOL));
			future.setTradeTimestamp(result.getJSONObject(i).getString(TRADE));
			future.setVolume(result.getJSONObject(i).getInt(VOLUME) + "");
			listFuture.add(future);
		}
		return listFuture;
	}

	public List<Future> getListFuture() {
		return showFutureData();
	}

	public void setListFuture(List<Future> listFuture) {
		this.listFuture = listFuture;
	}

}
