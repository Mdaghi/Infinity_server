package tn.esprit.infinity_server.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.infinity_server.interfaces.AffectationRemote;
import tn.esprit.infinity_server.persistence.Affectation;
import tn.esprit.infinity_server.persistence.AffectationPK;
import tn.esprit.infinity_server.persistence.BondsOffers;
import tn.esprit.infinity_server.persistence.DemandeBond;
@Stateless
public class AffectationService implements AffectationRemote{
	@PersistenceContext(unitName="infinity_server-ejb")
EntityManager em;
	@Override
	public int ajouterAffectation(int offid,int demid,LocalDate dateBond, LocalDate issueDate,LocalDate matureDate,Double price,Double couponRate ) {
		BondsOffers o= em.find(BondsOffers.class, offid);
		DemandeBond a= em.find(DemandeBond.class, demid);
		AffectationPK apk=new AffectationPK();
		apk.setIdDemande(demid);
		apk.setIdOffer(offid);
		Affectation affectation=new Affectation();
		affectation.setAffectationpk(apk);
		affectation.setBondsOffers(o);
		affectation.setDemandeBond(a);
		affectation.setCouponRate(couponRate);
		affectation.setDateBond(dateBond);
		affectation.setIssueDate(issueDate);
		affectation.setMatureDate(matureDate);
		affectation.setPrice(price);
		em.persist( affectation);
		return 0;	}

	@Override
	public void deleteAffectation(Affectation affectation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAffectation(int iddem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Affectation> getAffectation(){
		Query query=em.createQuery("select d From Affectation d ");
		return query.getResultList();
		
	}
	
	

	@Override
	public void updateAffectation(Affectation d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNbreAffectation() {
		// TODO Auto-generated method stub
		return 0;
	}

}
