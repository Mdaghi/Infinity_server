package tn.esprit.infinity_server.interfaces;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Bond;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.Trader;

@Remote
public interface ClientBondMangeRemote {

public void removeTrador() ;
public void demandBond(Bond b); //sell or buy

public void selectTrador(int idclient, int idTrader);

}
