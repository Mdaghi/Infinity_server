package tn.esprit.infinity_server.services;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import tn.esprit.infinity_server.persistence.OptionPut;


import tn.esprit.infinity_server.interfaces.OptionRemote;

@Stateless
public class ClientOptionService implements OptionRemote{

	@PersistenceContext(unitName="infinity_server-ejb")
	EntityManager em ;
	@Override
	public void createPutOption(OptionPut o) {
		
		em.persist(o);
		
	}

	@Override
	public void deleteOption(int IdOption) {
	
		em.remove(em.find(OptionPut.class,IdOption));
		
	}

	@Override
	public List<OptionPut> ListOptionPut(String c) {
	Query query=em.createQuery("select opt from OptionPut opt where opt.code like :c");
	query.setParameter("c",c);
	return query.getResultList();
	}

	@Override
	public Long findOptionPutByCode(String c) {
		Query query=em.createQuery("select COUNT(opt) from OptionPut opt where opt.code like :c");
		query.setParameter("c",c);
		return (Long) query.getSingleResult();
		
	}

	@Override
	public OptionPut getOptionById(int id) {
		OptionPut opt=em.find(OptionPut.class,id);
		return opt;
	}
    
	

}
