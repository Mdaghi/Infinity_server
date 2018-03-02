package tn.esprit.infinity_server.services;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.infinity_server.interfaces.UserLocal;
import tn.esprit.infinity_server.interfaces.UserRemote;
import tn.esprit.infinity_server.persistence.User;


/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserRemote, UserLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
   
	@Override
	public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:login and u.password=:password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(
					Level.WARNING,
					"authentication attempt failure with login=" + login
							+ " and password=" + password);
		}
		return found;
	}

	@Override
	public void CreateUser(User u) {
		em.persist(u);
	}

    
    
	
}
    
    
