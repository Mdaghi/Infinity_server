package tn.esprit.infinity_server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.AddressLocal;
import tn.esprit.infinity_server.interfaces.AddressRemote;
import tn.esprit.infinity_server.persistence.Address;

/**
 * Session Bean implementation class ServiceAddress
 */
@Stateless
public class ServiceAddress implements AddressRemote, AddressLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
  

	@Override
	public void CreateAddress(Address a) {
		em.persist(a);
		
	}

	@Override
	public void UpdateAddress(Address a) {
		em.refresh(a);
		
	}

	@Override
	public void RemoveAddress(Address a) {
		em.remove(a);
		
	}

	@Override
	public Address findAddressById(Integer id) {
		Address found = null;
		String jpql = "select a from Address a where a.id=:id";
		TypedQuery<Address> query = em.createQuery(jpql, Address.class);
		query.setParameter("id", id);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(Level.WARNING,
					"no such login=" + id);
		}
		return found;
	}

	@Override
	public List<Address> findAllAddress() {
		Query query = em.createQuery("SELECT a FROM Address a");
	    List<Address> resultList = (List<Address>)query.getResultList();
		return resultList;
	}
	

}
