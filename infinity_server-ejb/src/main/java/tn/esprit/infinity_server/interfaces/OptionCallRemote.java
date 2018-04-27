package tn.esprit.infinity_server.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import tn.esprit.infinity_server.persistence.OptionCall;

@Remote
public interface OptionCallRemote {

	public 	void createCallOption(OptionCall o, int idClient);
	public void deleteOption(int IdOption);
	public List <OptionCall> ListOptionCall();
	public int findOptionCallById(String c);
	
	public void updateStatutByID(String statut,int OptionCallId);
	

	public void removeOptionCallByCode(int idOptionCall);
	public double calculateOptionPrice(double S,double k, double T,double r,double q,
			 double vol );
	public Date convertDate(String s) throws ParseException;
	public double calculateMaturity(Date d1, Date d2);

	public List<OptionCall> StatutListOptionCall(String statut,int id);
	public OptionCall getOptionById(int c);
	public void UpdateCallOption(OptionCall o, int idClient,String statut,int idseller);
	public void UpdateCallOption(OptionCall o, String statut);
	public List<OptionCall> AvailableStatutListOptionCall(String statut, int idClient);
	
	public Long CountRow();
	public void removeDate();
	public double[] computeGreeks(double S, double K, double T, double r, double q, double vol);


	
	
}
