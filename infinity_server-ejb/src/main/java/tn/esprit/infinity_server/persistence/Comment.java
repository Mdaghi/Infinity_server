package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CommentPk commentPk;
	@ManyToOne
	@JoinColumn(name="idBondOffer",referencedColumnName="id",insertable=false,updatable=false)
	private BondsOffers bondOffer;
	@ManyToOne
	@JoinColumn(name="idCliet",referencedColumnName="id",insertable=false,updatable=false)
	private Client client;
	private String message;
	/*
	@ManyToOne
	@JoinColumn(name="commentId_FK")
	private Comment comentId;
	@OneToMany(mappedBy="comentId",fetch =FetchType.EAGER)
	private List<Comment> commentResponse;
*/
	public Comment() {

	}

	

	public CommentPk getCommentPk() {
		return commentPk;
	}



	public void setCommentPk(CommentPk commentPk) {
		this.commentPk = commentPk;
	}



	

	
	public BondsOffers getBondOffer() {
		return bondOffer;
	}



	public void setBondOffer(BondsOffers bondOffer) {
		this.bondOffer = bondOffer;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	



	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/*
	public Comment getCommentId() {
		return comentId;
	}



	public void setCommentId(Comment comentId) {
		this.comentId = comentId;
	}

	public List<Comment> getCommentResponse() {
		return commentResponse;
	}



	public void setCommentResponse(List<Comment> commentResponse) {
		this.commentResponse = commentResponse;
	}
	
	*/
	
	
	


	
}
