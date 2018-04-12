package tn.esprit.infinity_server.services;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.infinity_server.interfaces.BondsDemandRemote;
import tn.esprit.infinity_server.persistence.DemandeBond;

@Stateless
public class BondsDemande implements BondsDemandRemote{
	@PersistenceContext(unitName="infinity_server-ejb")
	EntityManager em;
	@Override
	public int ajouterDemande(DemandeBond demande) {
		
		em.persist(demande);
		return demande.getId();
	}
	@Override
	public void deletedemande(int iddem) {
		DemandeBond d=em.find(DemandeBond.class, iddem);
		em.remove(d);
	}
	@Override
	public List<DemandeBond> getDemandeBond() {
	Query query=em.createQuery("select d From DemandeBond d ORDER BY d.prix DESC");
	return query.getResultList();
	}
	
	@Override
	public void updateDemande(DemandeBond d) {
	em.merge(d);
		
	}
	@Override
	public void deletedemande(DemandeBond demande) {
	em.remove(demande);	
	}
	@Override
	public int getNbreDemande() {
		return getDemandeBond().size();
	}
	@Override
	public DemandeBond getdemandebond(int id) {
		DemandeBond d=em.find(DemandeBond.class,id);
		return d;
	}
	@Override
	public double getSommePrice() {
		Query query=em.createQuery("SELECT SUM(d.prix) From DemandeBond d where d.statutbond='affected'");
		return (double) query.getSingleResult();
	}
	@Override
	public double getSommePrice2() {
		Query query=em.createQuery("SELECT SUM(d.prix) From DemandeBond d where d.statutbond='not affected'");
		return (double) query.getSingleResult();
	}
	
}
