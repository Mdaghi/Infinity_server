package tn.esprit.infinity_server.services;

import java.math.BigInteger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.infinity_server.interfaces.RatingRemote;
import tn.esprit.infinity_server.persistence.BondsOffers;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.Rating;
import tn.esprit.infinity_server.persistence.RatingPk;
@Stateful
public class RatingService  implements RatingRemote {
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	@Override
	public void addRating(int idClient, int idBond, Double rate) {
			Client client =em.find(Client.class, idClient);
			BondsOffers bond=em.find(BondsOffers.class, idBond);
			RatingPk pk=new RatingPk();
			pk.setIdClient(client.getId());
			pk.setIdBond(bond.getId());
			Rating r=new Rating();
			r.setRatingPk(pk);
			r.setNote(rate);
			em.persist(r);
	}

	@Override
	public int rated(int idClient, int idBond) {
		Query result= em.createNativeQuery("SELECT count(*) FROM `rating` WHERE idClient=? and idBond=?" );
		result.setParameter(1, idClient);
		result.setParameter(2, idBond);
		
		return ((BigInteger) result.getSingleResult()).intValue();
	}

	@Override
	public Double getClientRate(int idClient, int idBond) {
		Query result= em.createNativeQuery("SELECT note FROM `rating` WHERE idClient=? and idBond=?" );
		result.setParameter(1, idClient);
		result.setParameter(2, idBond);
		
		return (Double) result.getSingleResult();
	}

	@Override
	public void updateRating(int idClient, int idBond, Double rate) {
		// TODO Auto-generated method stub
		
	}

}
