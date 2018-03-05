package tn.esprit.infinity_server.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infinity_server.interfaces.CommentRemote;
import tn.esprit.infinity_server.persistence.Comment;
@Stateless
public class CommentService implements CommentRemote{
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	@Override
	public void createComment(Comment comment) {
		em.persist(comment);
	}

	@Override
	public List<Comment> readAllCommentBond() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(Comment watchlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(int id) {
		Comment c=em.find(Comment.class, id);
		em.remove(c);
	}	
}
