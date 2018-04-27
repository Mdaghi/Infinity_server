package com.github.adminfaces.starter.infra.security;

import java.text.ParseException;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.infinity_server.persistence.OptionPut;
import tn.esprit.infinity_server.services.ClientOptionService;

@ManagedBean
@SessionScoped
public class OptionPutBean {
	private int id;

	private String code ;
	
	private String startdate;

	private Date expireddate ;
	
	private double SpotPrice ; 
	
	private double strikePrice; 
	
	private double priceOption ; 
	
	private String statut ;
	
	private double volatilty;

	private double rate ;
	
	private double T ;

	private double q ;
	

	@EJB
	ClientOptionService OptionService ;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public Date getExpireddate() {
		return expireddate;
	}


	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}


	public double getSpotPrice() {
		return SpotPrice;
	}


	public void setSpotPrice(double spotPrice) {
		SpotPrice = spotPrice;
	}


	public double getStrikePrice() {
		return strikePrice;
	}


	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}


	public double getPriceOption() {
		return priceOption;
	}


	public void setPriceOption(double priceOption) {
		this.priceOption = priceOption;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public double getVolatilty() {
		return volatilty;
	}


	public void setVolatilty(double volatilty) {
		this.volatilty = volatilty;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getT() {
		return T;
	}


	public void setT(double t) {
		T = t;
	}


	public double getQ() {
		return q;
	}


	public void setQ(double q) {
		this.q = q;
	}


	public void ajouterContract() throws ParseException {
		
		OptionPut optionPut =new OptionPut() ;
		
	}
	
	public <List> OptionPut getListOption () {
		return null ;
		
	}
	

}
