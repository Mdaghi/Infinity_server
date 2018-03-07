package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Comment;

@Remote
public interface CommentRemote {
	public void createComment(Comment comment);
	public List<Comment> readAllCommentBond();
	public void updateComment(Comment watchlist);
	public void deleteComment(int id);
}
