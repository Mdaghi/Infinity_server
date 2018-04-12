package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Contact {
	
	public void addContact(tn.esprit.infinity_server.persistence.Contact contact);
	public void addContact(tn.esprit.infinity_server.persistence.Contact contact , int idtrader );
	public void updateContact(tn.esprit.infinity_server.persistence.Contact contact);
	public void removeContact(int id);
	BondsOffers findContactById(Integer id);
	List<tn.esprit.infinity_server.persistence.Contact> findAllContact();
	List<tn.esprit.infinity_server.persistence.Contact> findContact(String rech);


}
