package tn.esprit.infinity_server.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.infinity_server.interfaces.BondsOffers;

@Stateless
public class BondsOffersServices implements BondsOffers{

	
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;	
	
	@Override
	public void addBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers) {
		em.persist(bondsoffers);
		
	}

	@Override
	public void updateBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers) {
        //em.refresh(bondsoffers);	
		Query query=em.createQuery("Update BondsOffers set owner=:owner");
		query.setParameter("owner",bondsoffers.getOwner());
		query.executeUpdate();
	
	}
	
	

	@Override
	public void removeBondsOffers(int id) {
		tn.esprit.infinity_server.persistence.BondsOffers bondsOffer=em.find(tn.esprit.infinity_server.persistence.BondsOffers.class, id);
		em.remove(bondsOffer);
		
	}
	
	@Override
	public BondsOffers findBondsOfferById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BondsOffers> findAllBondsOffers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
