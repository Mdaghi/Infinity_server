package com.github.adminfaces.starter.util;

import java.util.Date;

public class futureContractDataTable {
	private int id;
	private String symbol;
	private Double maturityPrice;
	private Date dateMaturite;
	private Integer size;
	private Double currentPrice;
	private String netChange;
	private String percentChange;
	private String gain;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getMaturityPrice() {
		return maturityPrice;
	}
	public void setMaturityPrice(Double maturityPrice) {
		this.maturityPrice = maturityPrice;
	}
	public Date getDateMaturite() {
		return dateMaturite;
	}
	public void setDateMaturite(Date dateMaturite) {
		this.dateMaturite = dateMaturite;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getNetChange() {
		return netChange;
	}
	public void setNetChange(String netChange) {
		this.netChange = netChange;
	}
	public String getPercentChange() {
		return percentChange;
	}
	public void setPercentChange(String percentChange) {
		this.percentChange = percentChange;
	}
	public String getGain() {
		return gain;
	}
	public void setGain(String gain) {
		this.gain = gain;
	}
	
	

}
