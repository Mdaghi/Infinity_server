package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private RatingPk ratingPk;
	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="ID",insertable=false,updatable=false, nullable = false)
	private Client client;
	@ManyToOne
	@JoinColumn(name="idBond",referencedColumnName="id",insertable=false,updatable=false, nullable = false)
	private BondsOffers bond;
	private double note;
	public Rating() {
		super();
	}
	public RatingPk getRatingPk() {
		return ratingPk;
	}
	public void setRatingPk(RatingPk ratingPk) {
		this.ratingPk = ratingPk;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public BondsOffers getBond() {
		return bond;
	}
	public void setBond(BondsOffers bond) {
		this.bond = bond;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Rating [ratingPk=" + ratingPk + ", client=" + client + ", bond=" + bond + ", note=" + note + "]";
	}
	
	
	
	
	
	
}
