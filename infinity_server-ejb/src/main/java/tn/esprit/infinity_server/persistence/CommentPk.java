package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
@Embeddable
public class CommentPk implements Serializable {
	private int idBondOffer;
	private int idCliet;
	private Date commentDate;
	public CommentPk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdBondOffer() {
		return idBondOffer;
	}
	public void setIdBondOffer(int idBondOffer) {
		this.idBondOffer = idBondOffer;
	}
	public int getIdCliet() {
		return idCliet;
	}
	public void setIdCliet(int idCliet) {
		this.idCliet = idCliet;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public boolean equals(Object arg0) {
		return commentDate.equals(arg0);
	}
	public int hashCode() {
		return commentDate.hashCode();
	}

	
}
