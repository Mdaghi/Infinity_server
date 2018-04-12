package tn.esprit.infinity_server.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.LikeRemote;
import tn.esprit.infinity_server.persistence.BondsOffers;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.LikePk;
import tn.esprit.infinity_server.persistence.Likes;

@Stateless
public class LikeService implements LikeRemote {
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	@Override
	public void LikeDislike(Likes l) {
		Client client=em.find(Client.class,l.getLikePk().getIdClient());
		BondsOffers bond=em.find(BondsOffers.class, l.getLikePk().getIdBond());

			LikePk likePk=new LikePk();
			likePk.setIdBond(bond.getId());
			likePk.setIdClient(client.getId());
			Likes like=new Likes();
			like.setLikePk(likePk);
			like.setLove(l.getLove());
			Date d=new Date();
			like.setLikedSince(d);
			em.persist(like);

	}
	
	@Override
	public void UpdateLikeDislike(Likes l) {
		Client client=em.find(Client.class,l.getLikePk().getIdClient());
		BondsOffers bond=em.find(BondsOffers.class, l.getLikePk().getIdBond());
		Query update=em.createNativeQuery("UPDATE likes set love=? where idClient=? and idBond=?");
		update.setParameter(1, l.getLove());
		update.setParameter(2, bond.getId());
		update.setParameter(3, bond.getId());
		update.executeUpdate();
	}
	

	@Override
	public int readBondLikesDisLikes(int idBond,int love) {
		Query query= em.createNativeQuery("select COUNT(*) from likes where idBond=? and love=?");
		query.setParameter(1, idBond);
		query.setParameter(2, love);
		return  ((BigInteger)query.getSingleResult()).intValue();
	}

	@Override
	public List<BondsOffers> readLikesClient(int idClient) {
		TypedQuery<BondsOffers> query=(TypedQuery<BondsOffers>) em.createNativeQuery("select b.* from BondsOffers b left join Likes l on b.id=l.idBond where l.idClient=?", BondsOffers.class);
		query.setParameter(1, idClient);
		return query.getResultList();
	}



	@Override
	public Integer likedBondClient(LikePk l) {
		Query rs= (TypedQuery<Integer>) em.createNativeQuery("SELECT love from likes where idClient=? and idBond=? ");
		rs.setParameter(1, l.getIdClient());
		rs.setParameter(2, l.getIdBond());
		return (Integer) rs.getSingleResult();
	}

	@Override
	public int dislikedBondClient(Likes l) {
		return 0;
	}

	@Override
	public Integer likesBetween(int idBond, Date dateLimite) {
		TypedQuery<Integer> result=(TypedQuery<Integer>) em.createNativeQuery("SELECT count(*) FROM `likes` WHERE likedSince>=?");
		result.setParameter(1, dateLimite);	
		return result.getSingleResult();
	}
	
	@Override
	public Integer likesDate(int idBond, String date) {
		Query result= em.createNativeQuery("SELECT count(*) FROM `likes` WHERE likedSince=? and love=1" );
		result.setParameter(1, date);	
		return ((BigInteger)result.getSingleResult()).intValue();
	}


	@Override
	public Integer countLikesDislikes() {
		TypedQuery<Integer> result=(TypedQuery<Integer>) em.createNativeQuery("SELECT count(*) FROM `likes`");
		return result.getSingleResult();	
		}




}
