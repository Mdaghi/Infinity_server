package com.github.adminfaces.starter.infra.security;



import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Faces;
import org.primefaces.component.log.Log;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javafx.scene.chart.XYChart;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.OptionPut;
import tn.esprit.infinity_server.services.ClientOptionService;

@ManagedBean
@SessionScoped
public class OptionPutBean implements Serializable {
	private int id;

	private String code ;
	
	private String startdate;
	
	
	private Date expireddate ;
	
	private double spotPrice ; 
	
	private double strikePrice; 
	
	private double priceOption ; 
	
	private String statut ;
	
	private double volatilty;

	private double rate ;
	
	private double T ;

	private double q ;
	
	private List <OptionPut> optionPuts ;
	
	private Client seller ;
	
	private int idBuyer ;
	
	private OptionPut selectedOption ;
	
	private int idselectedOption;
	
	private boolean visible ;
	
	private double[] BioCall ;

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
		return spotPrice;
	}


	public void setSpotPrice(double spotPrice) {
		this.spotPrice = spotPrice;
	}


	public double getStrikePrice() {
		return strikePrice;
	}


	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}


	public double getPriceOption() {
		return OptionService.calculateOptionPrice(spotPrice, strikePrice, 3, rate, q, volatilty) ;
		
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


	public double getT() throws ParseException {
	
	   return T ;
	   //DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	    //Date date = format.parse(startdate);
		//Calendar c = Calendar.getInstance ();
	    //Date date = c.getTime();
		//return OptionService.calculateMaturity(date, expireddate)  ;
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
    
	
	public Client getSeller() {
		return seller;
	}


	public void setSeller(Client seller) {
		this.seller = seller;
	}


	public int getIdBuyer() {
		return idBuyer;
	}


	public void setIdBuyer(int idBuyer) {
		this.idBuyer = idBuyer;
	}


	public OptionPutBean() {
		super();
	}

   
	public int getIdselectedOption() {
		return idselectedOption;
	}


	public void setIdselectedOption(int idselectedOption) {
		this.idselectedOption = idselectedOption;
	}


	public OptionPutBean(String code, String startdate, Date expireddate, double spotPrice, double strikePrice,
			double priceOption, String statut, double volatilty, double rate, double t, double q) {
		super();
		this.code = code;
		this.startdate = startdate;
		this.expireddate = expireddate;
		this.spotPrice = spotPrice;
		this.strikePrice = strikePrice;
		this.priceOption = priceOption;
		this.statut = statut;
		this.volatilty = volatilty;
		this.rate = rate;
		this.T = t;
		this.q = q;
	}
	
	
	public OptionPut getSelectedOption() {
		return selectedOption;
	}


	public void setSelectedOption(OptionPut selectedOption) {
		this.selectedOption = selectedOption;
	}


	public List<OptionPut> getOptionPuts() {
	
		optionPuts = OptionService.ListOptionPut();
		return optionPuts;
	}


	public void setOptionPuts(List<OptionPut> optionPuts) {
		this.optionPuts = optionPuts;
	}


   

	public double [] getBioCall() {
		  return BioCall ;
	}


	public void setBioCall(double[] bioCall) {
		BioCall = bioCall;
	}


	@PostConstruct
	public void init() {
    	
	selectedOption =new OptionPut() ;
	OptionService.removeDate();
	
	
	}
	public void addPutOption(int idClient){
		Calendar c = Calendar.getInstance ();
	    Date date = c.getTime();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    startdate= dateFormat.format(date);
	     
	    T= OptionService.calculateMaturity(expireddate,date)  ;
		
		OptionService.createPutOption(new OptionPut(startdate,  expireddate, spotPrice,  strikePrice,
				priceOption, "NotAvailable", volatilty, rate,  T,  q),  idClient);
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " ) );
	
	}
	
    public List<OptionPut> DisplayAvailableListPut (String s,int idClient){
    	
    	optionPuts =OptionService.StatutListOptionPut(s,idClient);
    	return optionPuts;
    }
    
 public List<OptionPut>   StatutListOptionPut (int idClient){
    	
    	List <OptionPut> optionP =OptionService.StatutListOptionPut("NotAvailable",idClient);
    	return optionP;
    }
    
  
 
	public double calculateOptionPrice (double S, double K, double T,double  r, double q,double  vol) {
		return OptionService.calculateOptionPrice(S, K, T, r, q, vol) ;
				
	}
	
	public double[] BIOCALL (int N, double S, double St, double u, double d) {
		
		return OptionService.BioCall(N, S, St, u, d);
	}

public double[] BICALLOPTION (double [] a, int N, double R, double u, double d,double  T) {
		
		return OptionService.BiOption(a, N, R, u, d, T) ;
	}

	public double maturity() {
	Calendar c = Calendar.getInstance ();
    Date stdate = c.getTime();

 
   
	
	double maturity =OptionService.calculateMaturity(stdate, expireddate);
    return maturity; 
	}
	
	public void BuyPutOption(OptionPut o,int idClient,int idseller) {
		
		OptionService.UpdatePutOption(o, idClient,"NotAvailable", idseller); 
  
}
	
	public void SellPutOption (OptionPut o){
		
		OptionService.UpdatePutOption(o, "Available");
		
	}
	
	public double[]  CalculateGreeks (){
		
		return OptionService.computeGreeks(spotPrice, strikePrice, T, rate, q, volatilty) ;
	}
	
	public double americanput () {
	
		int n=12;
	
		return OptionService.americanput( T,spotPrice, strikePrice, rate, volatilty, q, n) ;
	}
	public void onRowSelect(SelectEvent event) {
       OptionPut optionput= ((OptionPut)event.getObject());
	}
	
	
    public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public void show(){
    	
    	visible=true ;
    }
	public void hide(){
		
		visible=false ;
	}
  
  
   
   

}










