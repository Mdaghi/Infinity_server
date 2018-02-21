package tn.esprit.infinity_server.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.infinity_server.interfaces.TradorLocal;
import tn.esprit.infinity_server.interfaces.TradorRemote;

/**
 * Session Bean implementation class ServiceTrador
 */
@Stateless
@LocalBean
public class ServiceTrador implements TradorRemote, TradorLocal {

    /**
     * Default constructor. 
     */
    public ServiceTrador() {
        // TODO Auto-generated constructor stub
    }

}
