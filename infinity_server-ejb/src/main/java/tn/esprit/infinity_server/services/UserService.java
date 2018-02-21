package tn.esprit.infinity_server.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.infinity_server.interfaces.UserLocal;
import tn.esprit.infinity_server.interfaces.UserRemote;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserRemote, UserLocal {

    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }

}
