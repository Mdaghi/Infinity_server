package tn.esprit.infinity_server.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.CommentRemote;
import tn.esprit.infinity_server.persistence.Comment;
import tn.esprit.infinity_server.persistence.CommentPk;
import tn.esprit.infinity_server.persistence.Commentaire;
@Stateful
public class CommentService implements CommentRemote{
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	@Override
	public void createComment(Comment comment) {
		em.persist(comment);
	}
	@Override
	public List<Commentaire> readAllCommentBond(Integer idBond) {
		TypedQuery<Commentaire> result=(TypedQuery<Commentaire>) em.createNativeQuery("Select idClient,idBondOffer,commentDate,message from Comment where idBondOffer=? and commentParent_commentDate is null and commentParent_idBondOffer is null and commentParent_idClient is null", Commentaire.class);
		result.setParameter(1, idBond);
		return result.getResultList();
	}	
	@Override
	public List<Commentaire> readAllSubCommentsBond(CommentPk comment) {
		List<Commentaire> lc=new ArrayList<>();
		Query result= em.createNativeQuery("Select commentParent_idClient,commentParent_idBondOffer,commentDate,message from Comment where commentParent_idBondOffer=? and commentParent_idClient=? and commentParent_commentDate=?");
		result.setParameter(1,comment.getIdBondOffer());
		result.setParameter(2,comment.getIdClient());
		result.setParameter(3,comment.getCommentDate());
		List<Object[]> results = result.getResultList();
	    Commentaire commentaire = null;
	    for (Object[] objects : results) {
	        commentaire = new Commentaire();
	        commentaire.setIdBondOffer((Integer) objects[1]);
	        commentaire.setIdClient((Integer) objects[0]);
	        commentaire.setCommentDate((Date) objects[2]);
	        commentaire.setMessage((String) objects[3]);
	        
			lc.add(commentaire);
	    }
		
		return lc;
	}

	@Override
	public void updateComment(Comment watchlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(Comment comment) {
		
	}

	
}
