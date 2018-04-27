package tn.esprit.infinity_server.services;

import java.lang.Math;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.OptionCall;


import tn.esprit.infinity_server.interfaces.OptionCallRemote;

@Stateless
public class ClientOptionCallService implements OptionCallRemote{

	@PersistenceContext(unitName="infinity_server-ejb")
	EntityManager em ;
	@Override
	public void createCallOption(OptionCall o,int idClient) {
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
			    ("Select count(o) from OptionCall o");
			 Long countResult = (long)queryTotal.getSingleResult();
	return countResult;
		
	}
	@Override
	public void UpdateCallOption(OptionCall o,int idClient,String statut,int idseller) {
		Client client=em.find(Client.class, idseller);
		o.setSeller(client);
		o.setId_buyer(idClient);
		o.setStatut(statut);
		
		em.merge(o);
		
	}
	
	@Override
	public void UpdateCallOption(OptionCall o,String statut) {
	
		o.setStatut(statut);
		em.merge(o);
		
	}
	@Override
	public void deleteOption(int IdOption) {
	
		em.remove(em.find(OptionCall.class,IdOption));
		
	}
	
	@Override
	public List<OptionCall> ListOptionCall() {
	
	return em.createQuery("select o from OptionCall o", OptionCall.class).getResultList();
	}
	@Override
	public List<OptionCall> StatutListOptionCall(String statut,int idClient) {
		Client seller=em.find(Client.class, idClient);
		Query query=em.createQuery("SELECT o from OptionCall o WHERE o.statut = :statut and o.seller= :seller", OptionCall.class);
		query.setParameter("statut",statut);
		query.setParameter("seller",seller);
		return query.getResultList();
		
	}
	@Override
	public List<OptionCall> AvailableStatutListOptionCall(String statut,int idClient) {
		Client seller=em.find(Client.class, idClient);
		Query query=em.createQuery("SELECT o from OptionCall o WHERE o.statut = :statut and o.seller not like :seller", OptionCall.class);
		query.setParameter("statut",statut);
		query.setParameter("seller",seller);
		return query.getResultList();
		
	}
	
	public List<OptionCall> fetchData(){
		Query query=em.createQuery("SELECT o from OptionCall o ", OptionCall.class);
		return query.getResultList();

		
	}
	@Override
	public void removeDate(){
		Query query =em.createQuery("SELECT o from OptionCall o ", OptionCall.class);
		List<OptionCall> list =query.getResultList();
		for (OptionCall optioncall :list){
			
			 Calendar c = Calendar.getInstance ();
			 Date localdate = c.getTime();
			 Date expired = optioncall.getExpireddate();
			 double m=calculateMaturity(expired,localdate );
			 
			 if( m<0)
			 {
			removeOptionCallByCode(optioncall.getId());
			 }
			
		}
	}
	@Override
	public int findOptionCallById(String code) {
		Query query=em.createQuery("select opt.id from OptionCall opt where opt.code like :c");
		query.setParameter("c",code);
		return (int) query.getSingleResult();
		
	}

	@Override
	public OptionCall getOptionById(int c) {
		OptionCall opt=em.find(OptionCall.class,c);
		return opt;
	}

	

	@Override
	public void removeOptionCallByCode(int idOptionCall) {
	em.remove(em.find(OptionCall.class,idOptionCall));
	}

	
	
	@Override
	public void updateStatutByID(String statut, int OptionCallId) {
		Query query = em.createQuery("update OptionCall o set Statut=:statut where o.id=:OptionCallId");
		query.setParameter("statut", statut);
		query.setParameter("OptionCallId", OptionCallId);
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
	      price = S * CND(dplus) * Math.exp(-q * T) - K * CND(dminus) * Math.exp(-r * T); // price of a call option
	       
	      return price;
		
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
        greeks[0] = Math.exp(-q*T)*CND(dplus);
        // Vega
        greeks[1] = S*Math.exp(-q*T)*ND(dplus)*Math.sqrt(T);
        
        // Theta
        greeks[2] = -S*ND(dplus)*vol/(2*Math.sqrt(T))-r*K*Math.exp(-r*T)*CND(dminus)+q*S*Math.exp(-q*T)*CND(dplus);
       
        // Gamma
        greeks[3] = Math.exp(-q*T)*ND(dplus)/(S*vol*Math.sqrt(T)) ;
        
        // Rho
        greeks[4] = K*T*Math.exp(-r*T)*CND(dminus);
        
       
        return greeks;
     }
      
      public static double ND(double x) {
          return 1/Math.sqrt(2 * Math.PI) * Math.exp(-Math.pow(x,2)/2);
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

}