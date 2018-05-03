package com.github.adminfaces.starter.util;



import tn.esprit.infinity_server.util.Exchange;

public class Rates {
	private String symbole;
	
	private Exchange taux;
	public Exchange getTaux() {
		return taux;
	}
	public void setTaux(Exchange taux) {
		this.taux = taux;
	}
	public String getSymbole() {
		return symbole;
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	

}
