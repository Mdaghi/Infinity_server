    package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class CommentPk implements Serializable {
	@Column(name = "idBondOffer", nullable = true)
	private Integer idBondOffer;
	@Column(name = "idClient", nullable = true)
	private Integer idClient;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "commentDate", nullable = true)	
	private Date commentDate;
	public CommentPk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CommentPk(Integer idBondOffer, Integer idClient, Date commentDate) {
		super();
		this.idBondOffer = -1;
		this.idClient = -1;
		this.commentDate = new Date();
	}



	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdBondOffer() {
		return idBondOffer;
	}
	public void setIdBondOffer(Integer idBondOffer) {
		this.idBondOffer = idBondOffer;
	}
	
 	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result + idBondOffer;
		result = prime * result + idClient;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentPk other = (CommentPk) obj;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (idBondOffer != other.idBondOffer)
			return false;
		if (idClient != other.idClient)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentPk [idBondOffer=" + idBondOffer + ", idClient=" + idClient + ", commentDate=" + commentDate
				+ "]";
	}
	
	
	
	

	
}
