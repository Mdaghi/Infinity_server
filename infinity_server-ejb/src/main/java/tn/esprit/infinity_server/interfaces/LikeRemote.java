package tn.esprit.infinity_server.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.BondsOffers;
import tn.esprit.infinity_server.persistence.LikePk;
import tn.esprit.infinity_server.persistence.Likes;

@Remote
public interface LikeRemote {
	public void LikeDislike(Likes l);
	public void UpdateLikeDislike(Likes l);
	public Integer likedBondClient(LikePk l);
	public int dislikedBondClient(Likes l);
	public Integer likesBetween(int idBond,Date dateLimite);
	public Integer likesDate(int idBond, String string);
	public int readBondLikesDisLikes(int idBond,int love);
	public List<BondsOffers> readLikesClient(int idClient);
	public Integer countLikesDislikes();
	 
}
