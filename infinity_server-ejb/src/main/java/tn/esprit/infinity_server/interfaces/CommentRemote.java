package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Comment;
import tn.esprit.infinity_server.persistence.CommentPk;
import tn.esprit.infinity_server.persistence.Commentaire;

@Remote
public interface CommentRemote {
	public void createComment(Comment comment);
	public List<Commentaire> readAllCommentBond(Integer idBond);
	public List<Commentaire> readAllSubCommentsBond(CommentPk comment);
	public void updateComment(Comment watchlist);
	public void deleteComment(Comment comment);
}
