package tn.esprit.infinity_server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tn.esprit.infinity_server.interfaces.UserLocal;
import tn.esprit.infinity_server.interfaces.UserRemote;
import tn.esprit.infinity_server.persistence.Address;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserRemote, UserLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	/**
	 * Returns a User object from login and password else it will returns a null
	 * @param  login  a String that contain a login credentials
	 * @param  password a String containing a secret password
	 * @return User
	 */
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
			Logger.getLogger(UserService.class.getName()).log(Level.WARNING,
					"authentication attempt failure with login=" + login + " and password=" + password);
		}
		return found;
	}
	
	@Override
	public void CreateUser(User u) {
		em.persist(u);
	}

	@Override
	public boolean checkUniqueLogin(String login) {
		String jpql = "select u from User u where u.login=:login";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("login", login);
		try {
			if (query.getSingleResult() != null)
				return false;
			else
				return true;
		} catch (Exception ex) {
			return true;
		}
	}

	@Override
	public User getUserByLogin(String login) {
		User found = null;
		String jpql = "select u from User u where u.login=:login ";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("login", login);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(Level.WARNING,
					"authentication attempt failure with login=" + login);
		}
		return found;
	}

	@Override
	public void activateAccount(String login) {
		String jpql = "select u from User u where u.login=:login ";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("login", login);
		User user = query.getSingleResult();
		//
		user = em.find(User.class, user.getId());
		user.setActivate(1);
		em.merge(user);
	}

	@Override
	public void desactivateAccount(String login) {
		String jpql = "select u from User u where u.login=:login ";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("login", login);
		User user = query.getSingleResult();
		//
		user = em.find(User.class, user.getId());
		user.setActivate(0);
		em.merge(user);
	}

	@Override
	public User getUserById(User user) {
		User found = null;
		String jpql = "select u from User u where u.id=:id ";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("id", user.getId());
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(UserService.class.getName()).log(Level.WARNING,
					"authentication attempt failure with login=" + user.getId());
		}
		return found;
	}

	@Override
	public void updateUser(User user) {
		if (user instanceof Client) {
			Client c = (Client) user;
			Client u = em.find(Client.class, c.getId());
			u.setEmail(c.getEmail());
			u.setCode(c.getCode());
			u.setPassword(c.getPassword());
			u.setActivate(c.getActivate());
			u.setIsBanned(c.getIsBanned());
			//
			u.setFirstname(c.getFirstname());
			u.setLastname(c.getLastname());
			u.setPhoneNumber(c.getPhoneNumber());
			//
			em.merge(u);
			/*
			 * Address a = u.getAddress(); if (a != null) { a =
			 * em.find(Address.class,a.getId()); a = user.getAddress();
			 * em.refresh(a); }else u.setAddress(user.getAddress());
			 * em.merge(u);
			 */
		}
	}

	@Override
	public List<User> getAllClient() {
		Query query = em.createQuery("SELECT u FROM User u");
		List<User> resultList = (List<User>) query.getResultList();
		return resultList;
	}

}
