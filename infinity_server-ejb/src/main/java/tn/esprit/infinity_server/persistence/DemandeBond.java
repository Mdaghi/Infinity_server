package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Demande")

public class DemandeBond implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "dateDemande")
	private LocalDate dateDemande;
	@Column(name = "DateEmission")	
	private LocalDate dateEmission;
	@Column(name = "DateMaturite")
	private LocalDate dateMaturite;
	@Column(name = "Prix")
	private Double prix;
	@Column(name = "TauxCoupon")
	private double tauxCoupon;
	@Column(name = "Statutbond")
	private String statutbond;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy="demandeBond")
	private List<Affectation> affectation;
	
	
	
	public List<Affectation> getAffectation() {
		return affectation;
	}
	public void setAffectation(List<Affectation> affectation) {
		this.affectation = affectation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}
	public LocalDate getDateEmission() {
		return dateEmission;
	}
	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}
	public LocalDate getDateMaturite() {
		return dateMaturite;
	}
	public void setDateMaturite(LocalDate dateMaturite) {
		this.dateMaturite = dateMaturite;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public double getTauxCoupon() {
		return tauxCoupon;
	}
	public void setTauxCoupon(double tauxCoupon) {
		this.tauxCoupon = tauxCoupon;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getStatutbond() {
		return statutbond;
	}
	public void setStatutbond(String statutbond) {
		this.statutbond = statutbond;
	}
	
	
	
	
	
}
