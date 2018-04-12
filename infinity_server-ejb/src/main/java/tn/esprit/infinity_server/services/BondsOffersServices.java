package tn.esprit.infinity_server.services;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.BondsOffers;
import tn.esprit.infinity_server.persistence.Trader;

@Stateless
public class BondsOffersServices implements BondsOffers{

	
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;	
	
	@Override
	public void addBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers) {
		//Trader trader=em.find(Trader.class, arg)
		em.persist(bondsoffers);
		
	}

	@Override
	public void updateBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers) {        
		//Query query=em.createQuery("Update BondsOffers set denomination=:denomination , securitynumber=:securitynumber , owner=:owner ,  series=:series , issueDate=:issuedate , address=:address , printPlace=:printplace , printDate=:printdate , imgPath=:imgpath , couponRate=:couponrate , maturityDate=:maturitydate , frequencyRate=:frequencyrate , interestRate=:interestrate where id=:id");		
		//query.setParameter("interestrate",bondsoffers.getInterestRate());
		//query.executeUpdate();
		em.merge(bondsoffers);
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
	public List<tn.esprit.infinity_server.persistence.BondsOffers> findAllBondsOffers() {
		TypedQuery<tn.esprit.infinity_server.persistence.BondsOffers> query = em.createQuery("Select b from BondsOffers b",tn.esprit.infinity_server.persistence.BondsOffers.class);
		return query.getResultList();
	}

	@Override
	public List<tn.esprit.infinity_server.persistence.BondsOffers> findBonds(String rech) {
		
		return em.createQuery("SELECT b from BondsOffers b WHERE b.series LIKE :rech ",tn.esprit.infinity_server.persistence.BondsOffers.class).setParameter("rech", "%"+rech+"%").getResultList();
	}

	@Override
	public void addBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers, int idtrader) {
		// TODO Auto-generated method stub
		
		Trader trader=em.find(Trader.class, idtrader);
		bondsoffers.setTrader(trader);
				em.persist(bondsoffers);
		
	}

	@Override
	public Integer totalOfBonds() {
		Query result=em.createNativeQuery("Select count(*) from bondsOffers");
		int c = ((BigInteger) result.getSingleResult()).intValue();

		return c;
	}

	@Override
	public Float maxCouponRate() {
		Query result=em.createNativeQuery("select MIN(`couponrate`) FROM bondsoffers");
		Float c = ((float)result.getSingleResult());

		return c;
	}

	@Override
	public Float minCouponRate() {
		Query result=em.createNativeQuery("select MAX(`couponrate`) FROM bondsoffers");
		Float c = ((float)result.getSingleResult());
         
		return c;
	}

	@Override
	public java.sql.Date minIssueDate() {
		Query result=em.createNativeQuery("select MAX(`issuedate`) FROM bondsoffers");
		java.sql.Date c = (java.sql.Date) result.getSingleResult();
		return c;
	}

	@Override
	public tn.esprit.infinity_server.persistence.BondsOffers getofferbond(int id1) {
		return em.find(tn.esprit.infinity_server.persistence.BondsOffers.class, id1);
	}

	@Override
	public long getSommePrice3() {
		Query query=em.createQuery("SELECT SUM(d.denomination) From BondsOffers d where d.statusOffer='affected'");
		return (long) query.getSingleResult();
	}

	@Override
	public long getSommePrice4() {
		Query query=em.createQuery("SELECT SUM(d.denomination) From BondsOffers d where d.statusOffer='not affected'");
		return (long) query.getSingleResult();		
	}
	
}
