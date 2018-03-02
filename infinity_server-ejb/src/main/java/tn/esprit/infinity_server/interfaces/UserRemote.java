package tn.esprit.infinity_server.interfaces;	
import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.User;

@Remote
public interface UserRemote {

	public User authenticate(String login, String password);
	void CreateUser(User u);
}
