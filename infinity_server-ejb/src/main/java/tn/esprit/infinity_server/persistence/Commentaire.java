package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Commentaire implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idBondOffer;
	private Integer idClient;
	private Date commentDate;
	
	private String message;
	
	/*private Integer commentParent_idClient;
	private Integer commentParent_idBondOffer;
	private Date commentParent_commentDate;*/

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Commentaire(Integer idBondOffer, Integer idClient, Date commentDate, String message) {
		super();
		this.idBondOffer = idBondOffer;
		this.idClient = idClient;
		this.commentDate = commentDate;
		this.message = message;
	}


	public Integer getIdBondOffer() {
		return idBondOffer;
	}
	public void setIdBondOffer(Integer idBondOffer) {
		this.idBondOffer = idBondOffer;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	


	@Override
	public String toString() {
		return "Commentaire [idBondOffer=" + idBondOffer + ", idClient=" + idClient + ", commentDate=" + commentDate
				+"message:"+message+ "]";
	}

	
	
	
	
	
}
