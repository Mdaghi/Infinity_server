package tn.esprit.infinity_server.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.infinity_server.interfaces.AddressLocal;
import tn.esprit.infinity_server.interfaces.AddressRemote;

/**
 * Session Bean implementation class ServiceAddress
 */
@Stateless
@LocalBean
public class ServiceAddress implements AddressRemote, AddressLocal {

    /**
     * Default constructor. 
     */
    public ServiceAddress() {
        // TODO Auto-generated constructor stub
    }

}
