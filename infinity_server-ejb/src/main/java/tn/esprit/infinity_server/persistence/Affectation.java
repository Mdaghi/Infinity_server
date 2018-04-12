package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Affectation implements Serializable{

    @EmbeddedId
    private AffectationPK affectationpk;
    @ManyToOne
    @JoinColumn(name="idDemande", referencedColumnName="id", insertable=false, updatable=false)
	private DemandeBond demandeBond;
    @ManyToOne
    @JoinColumn(name="idOffer", referencedColumnName="id", insertable=false, updatable=false)
	private BondsOffers bondsOffers;
    @Column(name = "dateBond")
	private LocalDate dateBond;
	@Column(name = "issueDate")	
	private LocalDate issueDate;
	@Column(name = "matureDate")
	private LocalDate matureDate;
	@Column(name = "price")
	private Double price;
	@Column(name = "couponrate")
	private Double couponRate;
	
	
	
 
	public Double getCouponRate() {
		return couponRate;
	}
	public void setCouponRate(Double couponRate) {
		this.couponRate = couponRate;
	}
	public LocalDate getDateBond() {
		return dateBond;
	}
	public void setDateBond(LocalDate dateBond) {
		this.dateBond = dateBond;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getMatureDate() {
		return matureDate;
	}
	public void setMatureDate(LocalDate matureDate) {
		this.matureDate = matureDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public AffectationPK getAffectationpk() {
		return affectationpk;
	}
	public void setAffectationpk(AffectationPK affectationpk) {
		this.affectationpk = affectationpk;
	}
	public DemandeBond getDemandeBond() {
		return demandeBond;
	}
	public void setDemandeBond(DemandeBond demandeBond) {
		this.demandeBond = demandeBond;
	}
	public BondsOffers getBondsOffers() {
		return bondsOffers;
	}
	public void setBondsOffers(BondsOffers bondsOffers) {
		this.bondsOffers = bondsOffers;
	}
	
    
    
}
