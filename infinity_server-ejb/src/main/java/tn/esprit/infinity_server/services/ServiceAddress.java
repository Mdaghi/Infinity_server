package tn.esprit.infinity_server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		em.merge(a);

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
			Logger.getLogger(UserService.class.getName()).log(Level.WARNING, "no such login=" + id);
		}
		return found;
	}

	@Override
	public List<Address> findAllAddress() {
		Query query = em.createQuery("SELECT a FROM Address a");
		@SuppressWarnings("unchecked")
		List<Address> resultList = (List<Address>) query.getResultList();
		return resultList;
	}

	public void UpdateAddressByid(Address address) {
		String jpql = "update a from Address set a.street=:street " + " a.country =:country  "
				+ " a.number =:number  " + " a.city =:city  " + " a.postalCode =:postalCode  " + "where a.id=:id";
		Query query = em.createQuery(jpql, Address.class);
		query.setParameter("street", address.getId());
		query.setParameter("country", address.getId());
		query.setParameter("number", address.getId());
		query.setParameter("city", address.getId());
		query.setParameter("postalCode", address.getId());
		query.setParameter("id", address.getId());
		int modif = query.executeUpdate();
		if (modif == 1)
			System.out.println("modification ok ");
		else
			System.out.println("modification non ");

	}

}
