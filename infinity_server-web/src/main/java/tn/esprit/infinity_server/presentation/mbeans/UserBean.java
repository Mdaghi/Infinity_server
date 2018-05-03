package tn.esprit.infinity_server.presentation.mbeans;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tn.esprit.infinity_server.persistence.User;



@ManagedBean
@SessionScoped
public class UserBean {
		
	private User user;
	


	@PostConstruct
	public void init() {

	}


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	

}
