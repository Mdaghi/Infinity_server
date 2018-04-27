package tn.esprit.infinity_server.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import tn.esprit.infinity_server.persistence.OptionCall;
import tn.esprit.infinity_server.persistence.OptionPut;

@Remote
public interface OptionRemote {

	public 	void createPutOption(OptionPut o, int idClient);
	public void deleteOption(int IdOption);
	public List <OptionPut> ListOptionPut();
	public int findOptionPutById(String c);
	
	public void updateStatutByID(String statut,int OptionPutId);
	

	
	public double calculateOptionPrice(double S,double k, double T,double r,double q,
			 double vol );
	public Date convertDate(String s) throws ParseException;
	public double calculateMaturity(Date d1, Date d2);

	public List<OptionPut> StatutListOptionPut(String statut,int id);
	public OptionPut getOptionById(int c);
	public void UpdatePutOption(OptionPut o, int idClient,String statut,int idseller);
	public void UpdatePutOption(OptionPut o, String statut);
	public List<OptionPut> AvailableStatutListOptionPut(String statut, int idClient);
	
	public Long CountRow();
	public void removeOptionPutByCode(int idOptionPut);
	public void removeDate();
	void removeOptionPutByCode(String codeOptionPut);
	public double[] computeGreeks(double S, double K, double T, double r, double q, double vol);


	
	
}
