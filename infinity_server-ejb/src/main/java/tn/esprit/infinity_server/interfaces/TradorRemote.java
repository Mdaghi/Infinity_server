package tn.esprit.infinity_server.interfaces;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Client;

@Remote
public interface TradorRemote {
	public void CreateTrader(Client c);

}
