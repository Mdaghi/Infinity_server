package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="bondsoffers")
public class BondsOffers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7390501749465285661L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "denomination", nullable = false)
	private Long denomination;
	@Column(name = "securitynumber", nullable = false)
	private Long securityNumber;
	@Column(name = "owner", nullable = false)
	private String owner;
	@Column(name = "series", nullable = false)
	private String series;
	@Column(name = "issuedate", nullable = false)
	private java.sql.Date issueDate;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "printplace", nullable = false)
	private String printPlace;
	@Column(name = "printdate", nullable = false)
	private java.sql.Date printDate;
	@Column(name = "imgpath", nullable = true)
	private String imgPath;
	@Column(name = "couponrate", nullable = false)
	private Float couponRate;
	@Column(name = "maturitydate", nullable = false)
	private java.sql.Date maturityDate;
	@Column(name = "frequencyrate", nullable = false)
	private String frequencyRate;
	@Column(name = "interestrate", nullable = false)
	private String interestRate;
	@ManyToOne
	private Trader trader;
	
	@OneToMany(mappedBy="bond")
	private List<WatchListBonds> watchlistBonds;
	
	public BondsOffers(){
		
	}

	public int getId() {
		return id;
	}
	public Long getDenomination() {
		return denomination;
	}
	public Long getSecurityNumber() {
		return securityNumber;
	}
	public String getOwner() {
		return owner;
	}
	public String getSeries() {
		return series;
	}
	public java.sql.Date getIssueDate() {
		return issueDate;
	}
	public String getAddress() {
		return address;
	}
	public String getPrintPlace() {
		return printPlace;
	}
	public java.sql.Date getPrintDate() {
		return printDate;
	}
	public String getImgPath() {
		return imgPath;
	}
	public Float getCouponRate() {
		return couponRate;
	}
	public java.sql.Date getMaturityDate() {
		return maturityDate;
	}
	public String getFrequencyRate() {
		return frequencyRate;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public Trader getTrador() {
		return trader;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDenomination(Long denomination) {
		this.denomination = denomination;
	}
	public void setSecurityNumber(Long securityNumber) {
		this.securityNumber = securityNumber;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public void setIssueDate(java.sql.Date issueDate) {
		this.issueDate = issueDate;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPrintPlace(String printPlace) {
		this.printPlace = printPlace;
	}
	public void setPrintDate(java.sql.Date printDate) {
		this.printDate = printDate;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public void setCouponRate(Float couponRate) {
		this.couponRate = couponRate;
	}
	public void setMaturityDate(java.sql.Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public void setFrequencyRate(String frequencyRate) {
		this.frequencyRate = frequencyRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	///////WatchList//////////////


	public List<WatchListBonds> getWatchlistBonds() {
		return watchlistBonds;
	}

	public void setWatchlistBonds(List<WatchListBonds> watchlistBonds) {
		this.watchlistBonds = watchlistBonds;
	}

	

	
}
