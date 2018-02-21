package tn.esprit.infinity_server.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.infinity_server.interfaces.CurrencyAccountLocal;
import tn.esprit.infinity_server.interfaces.CurrencyAccountRemote;

/**
 * Session Bean implementation class CurrencyAccount
 */
@Stateless
@LocalBean
public class CurrencyAccountService implements CurrencyAccountRemote, CurrencyAccountLocal {

    /**
     * Default constructor. 
     */
    public CurrencyAccountService() {
        // TODO Auto-generated constructor stub
    }

}
