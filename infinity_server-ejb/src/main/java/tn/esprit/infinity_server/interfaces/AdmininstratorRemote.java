package tn.esprit.infinity_server.interfaces;
import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Administrator;
import tn.esprit.infinity_server.persistence.Trader;

@Remote
public interface AdmininstratorRemote {
	public void CreateAdmin(Administrator admin);
}
