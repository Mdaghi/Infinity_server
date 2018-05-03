package tn.esprit.infinity_server.services;

import java.lang.Math;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.OptionCall;
import tn.esprit.infinity_server.persistence.OptionPut;
import tn.esprit.infinity_server.persistence.WatchList;
import tn.esprit.infinity_server.interfaces.OptionRemote;

@Stateless
@LocalBean
public class ClientOptionService implements OptionRemote{

	@PersistenceContext(unitName="infinity_server-ejb")
	EntityManager em ;
	@Override
	public void createPutOption(OptionPut o,int idClient) {
		Client client=em.find(Client.class, idClient);
		o.setSeller(client);
         Long n=CountRow();
         System.out.println(n);
		o.setCode("OPTPUT"+n);
		em.persist(o);
		
	}
	@Override
	public Long CountRow() {
		Query queryTotal = em.createQuery
			    ("Select count(o) from OptionPut o");
			 Long countResult = (long)queryTotal.getSingleResult();
	return countResult;
		
	}
	@Override
	public void UpdatePutOption(OptionPut o,int idClient,String statut,int idseller) {
		
		Client client=em.find(Client.class, idseller);
		o.setSeller(client);
		o.setId_buyer(idClient);
		o.setstatut(statut);
		em.merge(o);
		
	}
	
	@Override
	public void UpdatePutOption(OptionPut o,String statut) {
	
		o.setstatut(statut);
		em.merge(o);
		
	}
	@Override
	public void removeDate(){
		Query query =em.createQuery("SELECT o from OptionPut o ", OptionPut.class);
		List<OptionPut> list =query.getResultList();
		for (OptionPut optionput :list){
			
			 Calendar c = Calendar.getInstance ();
			 Date localdate = c.getTime();
			 Date expired = optionput.getExpireddate();
			 double m=calculateMaturity(expired,localdate );
			 
			 if( m<0)
			 {
			removeOptionPutByCode(optionput.getId());
			 }
			
		}
	}
	@Override
	public void removeOptionPutByCode(int idOptionPut) {
	em.remove(em.find(OptionPut.class,idOptionPut));
	}


	
	@Override
	public List<OptionPut> ListOptionPut() {
	
	return em.createQuery("select o from OptionPut o", OptionPut.class).getResultList();
	}
	@Override
	public List<OptionPut> StatutListOptionPut(String statut,int idClient) {
		Client seller=em.find(Client.class, idClient);
		Query query=em.createQuery("SELECT o from OptionPut o WHERE o.statut = :statut and o.seller= :seller", OptionPut.class);
		query.setParameter("statut",statut);
		query.setParameter("seller",seller);
		return query.getResultList();
		
	}
	@Override
	public List<OptionPut> AvailableStatutListOptionPut(String statut,int idClient) {
		Client seller=em.find(Client.class, idClient);
		Query query=em.createQuery("SELECT o from OptionPut o WHERE o.statut = :statut and o.seller not like :seller", OptionPut.class);
		query.setParameter("statut",statut);
		query.setParameter("seller",seller);
		return query.getResultList();
		
	}
	@Override
	public int findOptionPutById(String code) {
		Query query=em.createQuery("select opt.id from OptionPut opt where opt.code like :c");
		query.setParameter("c",code);
		return (int) query.getSingleResult();
		
	}

	@Override
	public OptionPut getOptionById(int c) {
		OptionPut opt=em.find(OptionPut.class,c);
		return opt;
	}

	

	@Override
	public void removeOptionPutByCode(String codeOptionPut) {
	em.remove(em.find(OptionPut.class,codeOptionPut));
	}


	
	@Override
	public void updateStatutByID(String statut, int OptionPutId) {
		Query query = em.createQuery("update OptionPut o set Statut=:statut where o.id=:OptionPutId");
		query.setParameter("statut", statut);
		query.setParameter("OptionPutId", OptionPutId);
		int modified = query.executeUpdate();
		if(modified == 1){
			System.out.println("successfully updated");
		}else{
			System.out.println("failed to update");
		}
		
	}
    
	
	@Override
	 public double calculateOptionPrice (double S,double K, double T,double r,double q,
			 double vol ){
		
		  double dplus = (Math.log(S / K) + (r - q + Math.pow(vol,2) / 2) * T) / (vol * Math.sqrt(T));
	      double dminus = dplus - vol * Math.sqrt(T);
	      double price;
	     
	       price = S * -1 * CND(-dplus) * Math.exp(-q * T) + K * CND(-dminus) * Math.exp(-r * T);             // price of a put option
	      return price;
		
	}

	public static double CND(double x) {
		 // coefficients obtained
	      double a1 = 0.31938153;
	      double a2 = -0.356563782;
	      double a3 = 1.781477937;
	      double a4 = -1.821255978;
	      double a5 = 1.330274429;

	      double L = Math.abs(x);
	      double K = 1 / (1 + 0.2316419 * L);
	      double res = 1 - 1 / Math.sqrt(2 * Math.PI) * Math.exp(-Math.pow(L,2) / 2) * (a1 * K + a2 * Math.pow(K,2) + a3 * Math.pow(K,3) + a4 * Math.pow(K,4) + a5 * Math.pow(K,5));
	      if (x<0)
	         // if x negative, then reverse approximation by applying 1-x
	         res = 1 - res;
	      return res;
	}
	@Override 
	 public double[] computeGreeks (double S,double K, double T,double r,double q,
			 double vol )
	{
	 double dplus = (Math.log(S / K) + (r - q + Math.pow(vol,2) / 2) * T) / (vol * Math.sqrt(T));
    double dminus = dplus - vol * Math.sqrt(T);
    // compute Delta, Vega, Psi, Theta, Rho, Gamma and Volga
    double[] greeks = new double[7];
 // Delta
    greeks[0] = -Math.exp(-q*T)*CND(-dplus);
    // Vega
    greeks[1] = S*Math.exp(-q*T)*ND(dplus)*Math.sqrt(T);
  
    // Theta
    greeks[2] = -S*ND(dplus)*vol/(2*Math.sqrt(T))+r*K*Math.exp(-r*T)*CND(-dminus)-q*S*Math.exp(-q*T)*CND(-dplus);
    // Gamma
    greeks[3] = Math.exp(-q*T)*ND(dplus)/(S*vol*Math.sqrt(T)) ;
    // Rho
    greeks[4] = -K*T*Math.exp(-r*T)*CND(-dminus);
  

    
       
       return greeks;
    }
     
     public static double ND(double x) {
         return 1/Math.sqrt(2 * Math.PI) * Math.exp(-Math.pow(x,2)/2);
      }
    
	@Override
	public Date convertDate(String s) throws ParseException {
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		Date date = sdf.parse(s);
		
		return date ;
		
	}
	
	@Override
	public double calculateMaturity(Date d1, Date d2)
	{
		double maturity ;
		maturity=  (d1.getTime()-d2.getTime())/86400000;
	        return maturity;
		 
		 
	
	}
	@Override
	public void deleteOption(int IdOption) {
		// TODO Auto-generated method stub
		
	}

}
