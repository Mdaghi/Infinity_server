package tn.esprit.infinity_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.BondsOffers;
import tn.esprit.infinity_server.interfaces.Contact;

@Stateless
public class ContactServices implements Contact {
	
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	@Override
	public void addContact(tn.esprit.infinity_server.persistence.Contact contact) {
		// TODO Auto-generated method stub
		em.persist(contact);
		
	}

	@Override
	public void addContact(tn.esprit.infinity_server.persistence.Contact contact, int idtrader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact(tn.esprit.infinity_server.persistence.Contact contact) {
		// TODO Auto-generated method stub

		em.merge(contact);
		
	}

	@Override
	public void removeContact(int id) {
		// TODO Auto-generated method stub
		tn.esprit.infinity_server.persistence.Contact contact=em.find(tn.esprit.infinity_server.persistence.Contact.class, id);
		em.remove(contact);
	}

	@Override
	public BondsOffers findContactById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<tn.esprit.infinity_server.persistence.Contact> findAllContact() {
		// TODO Auto-generated method stub
		TypedQuery<tn.esprit.infinity_server.persistence.Contact> query = em.createQuery("Select c from Contact c",tn.esprit.infinity_server.persistence.Contact.class);
		return query.getResultList();
		
	}

	@Override
	public List<tn.esprit.infinity_server.persistence.Contact> findContact(String rech) {
		// TODO Auto-generated method stub
		return null;
	}	

}
