package tn.esprit.infinity_server.interfaces;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.User;

@Remote
public interface ClientRemote {
	public void updateClient(Client client);
}
