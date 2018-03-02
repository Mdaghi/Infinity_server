package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Demande")

public class DemandeBond implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "dateDemande", nullable = false)
	private LocalDateTime dateDemande;
	@Column(name = "DateEmission", nullable = false)	
	private LocalDateTime dateEmission;
	@Column(name = "DateMaturite", nullable = false)
	private LocalDateTime dateMaturite;
	@Column(name = "Prix", nullable = false)
	private Double prix;
	@Column(name = "TauxCoupon", nullable = false)
	private double tauxCoupon;
	@ManyToOne
	private Client client;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(LocalDateTime dateDemande) {
		this.dateDemande = dateDemande;
	}
	public LocalDateTime getDateEmission() {
		return dateEmission;
	}
	public void setDateEmission(LocalDateTime dateEmission) {
		this.dateEmission = dateEmission;
	}
	public LocalDateTime getDateMaturite() {
		return dateMaturite;
	}
	public void setDateMaturite(LocalDateTime dateMaturite) {
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
	
	
	
	
}
