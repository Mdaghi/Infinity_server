package com.github.adminfaces.starter.infra.security;

import com.github.adminfaces.template.session.AdminSession;

import tn.esprit.infinity_server.persistence.Administrator;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.User;
import tn.esprit.infinity_server.services.UserService;

import org.omnifaces.util.Faces;

import javax.ejb.EJB;

import javax.enterprise.inject.Specializes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

/**
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login
 * page or not. By default AdminSession isLoggedIn always resolves to true so it
 * will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user
 * must be redirect to initial page or logon you can skip this class.
 */
@Named
@SessionScoped
@Specializes
@ManagedBean
public class LogonMB extends AdminSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserService userService;

	public static User user;
	private String currentUser;
	private String login;
	private String password;
	private boolean remember;

	public void login() throws IOException {
		currentUser = login;
		user = userService.authenticate(login, password);
		if (user == null)
			return;
		addDetailMessage("Logged in successfully as <b>" + login + "</b>");
		Faces.getExternalContext().getFlash().setKeepMessages(true);
		if (user instanceof Client)
			Faces.redirect("index.jsf");
		else if (user instanceof Administrator)
			Faces.redirect("admin/admin.jsf");
		else
			return;

	}


	public void logout() throws IOException {
		Faces.getExternalContext().invalidateSession();
		Faces.redirect("login.jsf");
		user=null;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public boolean isLoggedIn() {

		return currentUser != null;
	}

}
