package tn.esprit.infinity_server.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Exchanger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.kevinsawicki.http.HttpRequest;



public class FutureJson {

	public List<Future> showHistoriqueDataBySymbole(String symbole) {
		String response = HttpRequest
				.get("https://marketdata.websol.barchart.com/getHistory.json?apikey=5762666332e2d8a7b5374845ed4c5513&symbol="
						+ symbole + "&type=daily&startDate=20180100000000")
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		//
		JSONObject status = jsonObject.getJSONObject("status");
		String strCode = status.getDouble("code")+"";
		if(!strCode.equals("200.0"))
			return Collections.emptyList(); 
		//
		JSONArray result = jsonObject.getJSONArray("results");
		List<Future> lst = new ArrayList<>();
		for (int i = 0; i < result.length(); i++) {
			JSONObject data = result.getJSONObject(i);
			Future future = new Future();
			future.setRef(i + "");
			future.setClose(data.getDouble("close") + "");
			future.setVolume(data.getInt("volume") + "");
			future.setTradeTimestamp(data.getString("tradingDay"));
			lst.add(future);
		}
		return lst;
	}
	public List<Future> showFutureData(String symbols) {
		String response = HttpRequest
				.get("https://marketdata.websol.barchart.com"
						+ "/getQuote.json?apikey=5762666332e2d8a7b5374845ed4c5513&symbols=" + symbols)
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		//
		JSONObject status = jsonObject.getJSONObject("status");
		String strCode = status.getDouble("code")+"";
		if(!strCode.equals("200.0"))
			Collections.emptyList(); 
		//
		JSONArray result = jsonObject.getJSONArray("results");
		List<Future> lst = new ArrayList<>();
		for (int i = 0; i < result.length(); i++) {
			JSONObject data = result.getJSONObject(i);
			Future future = new Future();
			future.setRef(i + "");
			future.setClose(data.getDouble("close") + "");
			future.setHigh(data.getDouble("high") + "");
			future.setLastPrice(data.getDouble("lastPrice") + "");
			future.setLow(data.getDouble("low") + "");
			future.setName(data.getString("name"));
			future.setNetChange(data.getDouble("netChange") + "");
			future.setOpen(data.getDouble("open") + "");
			future.setPercentChange(data.getDouble("percentChange") + "");
			future.setSymbol(data.getString("symbol"));
			future.setTradeTimestamp(data.getString("tradeTimestamp"));
			future.setVolume(data.getInt("volume") + "");
			future.setName(data.getString("name"));
			lst.add(future);
		}
		return lst;
	}
	
	public Exchange currencyConvertion(String from)
	{
		Exchange exchange = new Exchange();
		String response = HttpRequest
				.get("https://v3.exchangerate-api.com/bulk/428d417084fe51418dc991a4/"+from)
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		JSONObject status = jsonObject.getJSONObject("rates");
		exchange.setUsd(status.getDouble("usd")+"");
		exchange.setEur(status.getDouble("eur")+"");
		exchange.setAud(status.getDouble("aud")+"");
		exchange.setCad(status.getDouble("cad")+"");
		exchange.setCny(status.getDouble("cny")+"");
		exchange.setInr(status.getDouble("inr")+"");
		exchange.setGpb(status.getDouble("gpb")+"");
		exchange.setJpy(status.getDouble("jpy")+"");
		exchange.setRub(status.getDouble("rub")+"");
		exchange.setTnd(status.getDouble("tnd")+"");
		return exchange;
		
	
	}
	
	
	
	
}
