package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	@JoinColumn(name="idClient",referencedColumnName="id",nullable=true,insertable=false,updatable=false)
	private Client client;
	private String message;
	
	@ManyToOne
	private Comment commentParent;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "commentParent", cascade = CascadeType.ALL)
	private List<Comment> commentsChild;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(CommentPk commentPk, BondsOffers bondOffer, Client client, String message) {
		super();
		
		CommentPk pk=new CommentPk(0,0,new Date());
		this.commentPk = commentPk;
		this.bondOffer = bondOffer;
		this.client = client;
		this.message = message;
		this.commentParent.setCommentPk(pk);
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
	/*@Override
	public String toString() {
		return "Comment [idClient=" + commentPk.getIdClient()+ "idBond=" + commentPk.getIdBondOffer()+"date=" + commentPk.getCommentDate()+ ", message="
				+ message + "]";
	}*/
	@Override
	public String toString() {
		return "Comment [idClient=" + commentPk.getIdClient()+ "idBond=" + commentPk.getIdBondOffer()+"date=" + commentPk.getCommentDate()+  ", message="
				+ message + ", commentParent=" + commentParent + "]";
	}
	
	
	
	
}
