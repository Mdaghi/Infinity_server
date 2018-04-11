package tn.esprit.infinity_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface RatingRemote {
	public void addRating(int idClient,int idBond,Double rate);
	public int rated(int idClient,int idBond);
	public Double getClientRate(int idClient,int idBond);
	public void updateRating(int idClient,int idBond,Double rate);
	
}
