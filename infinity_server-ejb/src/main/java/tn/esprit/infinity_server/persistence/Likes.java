package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Likes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private LikePk likePk;
	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="ID",insertable=false,updatable=false, nullable = false)
	private Client client;
	@ManyToOne
	@JoinColumn(name="IDBOND",referencedColumnName="id",insertable=false,updatable=false, nullable = false)
	private BondsOffers bond;
	private int love;
	@Column(name="likedSince")
	@Temporal(TemporalType.DATE)
	private Date LikedSince;
	

	
	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikePk getLikePk() {
		return likePk;
	}


	public void setLikePk(LikePk likePk) {
		this.likePk = likePk;
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


	
	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public Date getLikedSince() {
		return LikedSince;
	}

	public void setLikedSince(Date likedSince) {
		LikedSince = likedSince;
	}


	
	
	
	
}
