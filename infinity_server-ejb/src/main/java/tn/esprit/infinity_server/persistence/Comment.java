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
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CommentPk commentPk;
	@ManyToOne
	@JoinColumn(name="idBondOffer",referencedColumnName="id",nullable=true,insertable=false,updatable=false)
	private BondsOffers bondOffer;
	@ManyToOne
	@JoinColumn(name="idCliet",referencedColumnName="id",nullable=true,insertable=false,updatable=false)
	private Client client;
	private String message;
	
	@ManyToOne
	private Comment commentParent;
	@OneToMany(mappedBy="commentParent")
	private List<Comment> commentsChild;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Comment getCommentParent() {
		return commentParent;
	}
	public void setCommentParent(Comment commentParent) {
		this.commentParent = commentParent;
	}

	public List<Comment> getCommentsChild() {
		return commentsChild;
	}
	public void setCommentsChild(List<Comment> commentsChild) {
		this.commentsChild = commentsChild;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
