package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date ;

 
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="OPTION_PUT")
public class OptionPut implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Id
	private int id;
	@Column(name = "CODE")
	private String code ;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startdate ;*/
	
	@Column(name = "START_DATE")
	private String startdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRED_DATE")
	private Date expireddate ;
	
	@Column(name = "ASSET_PRICE") // spot price
	private double SpotPrice ; 
	
	//prix de l'exercice 
	@Column(name = "Strike_PRICE")
	private double strikePrice; 
	
	// price of the option
	@Column(name = "PRICE_OPTION")
	private double priceOption ; 
	
	@Column(name = "STATUT")
	private String statut ;
	
	@Column(name="VOLATILITY")
	private double volatilty;
	
	@Column(name="RATE") // Annual yield rate 
	private double rate ;
	
	@Column(name="T_MATURITY")
	private double T ;
	
	@Column(name="DIVIDEND_RATE")
	private double q ;
	
	@ManyToOne
	private Client seller ;
	 
	private int Id_buyer ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getstatut() {
		return statut;
	}
	public void setstatut(String statut) {
		this.statut = statut;
	}
	
	
	
	
	public int getId_buyer() {
		return Id_buyer;
	}
	public void setId_buyer(int id_buyer) {
		Id_buyer = id_buyer;
	}
	public double getSpotPrice() {
		return SpotPrice;
	}
	public void setSpotPrice(double SpotPrice) {
		this.SpotPrice = SpotPrice;
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
	public Client getSeller() {
		return seller;
	}
	public void setSeller(Client seller) {
		this.seller = seller;
	}

	public OptionPut() {
		super();
	}
	public OptionPut(String code) {
		super();
		this.code = code;
	}
	public OptionPut( String code , double strikePrice, double priceOption,String startdate ,Date expireddate,String statut){
		this.startdate = startdate;
		this.expireddate = expireddate;
		this.strikePrice = strikePrice;
		this.priceOption = priceOption;
		this.code = code;
		this.statut=statut;
	}
	public OptionPut( String code , double strikePrice, double priceOption){
		
		this.strikePrice = strikePrice;
		this.priceOption = priceOption;
		this.code = code;
		
	}
	public OptionPut( String code , double strikePrice){
		
		this.strikePrice = strikePrice;
		
		this.code = code;
		
	}
	public OptionPut(String startdate, Date expireddate, double SpotPrice, double strikePrice,
			double priceOption, String statut, double volatilty, double rate,
			double T, double q) {
		super();
		
		this.startdate = startdate;
		this.expireddate = expireddate;
		this.SpotPrice = SpotPrice;
		this.strikePrice = strikePrice;
		this.priceOption = priceOption;
		this.statut = statut;
		this.volatilty = volatilty;
		this.rate = rate;
		this.T= T;
		this.q=q;
	}
	public OptionPut(String startdate, Date expireddate, double spotPrice, double strikePrice,
			double priceOption, String statut, double volatilty, double rate, double t, double q, Client seller) {
		super();
		
		this.startdate = startdate;
		this.expireddate = expireddate;
		SpotPrice = spotPrice;
		this.strikePrice = strikePrice;
		this.priceOption = priceOption;
		this.statut = statut;
		this.volatilty = volatilty;
		this.rate = rate;
		T = t;
		this.q = q;
		this.seller = seller;
	}
	
	
}
