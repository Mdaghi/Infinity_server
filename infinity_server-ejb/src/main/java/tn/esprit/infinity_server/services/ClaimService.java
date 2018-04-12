package tn.esprit.infinity_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.infinity_server.interfaces.ClaimRemote;
import tn.esprit.infinity_server.persistence.Claim;


@Stateless
public class ClaimService implements ClaimRemote{
	@PersistenceContext(unitName="infinity_server-ejb")
	EntityManager em;
	@Override
	public int ajouterClaim(Claim claim) {
		em.persist(claim);
		return claim.getId();
	}

	@Override
	public void deleteClaim(Claim claim) {
	}

	@Override
	public void deleteClaim(int iddem) {
		Claim d=em.find(Claim.class, iddem);
		em.remove(d);
	}

	@Override
	public List<Claim> getClaims() {
		
		Query query=em.createQuery("select a From Claim a");
		
		return query.getResultList();
	}

	@Override
	public void updateClaim(Claim d) {
		em.merge(d);
	}

	@Override
	public int getNbreClaim() {
		return getClaims().size();
	}

	@Override
	public List<Claim> getClaimsforAdmin() {
		Query query=em.createQuery("select a From Claim a where a.status='not treated' ");
		return query.getResultList();
	}

	
}
