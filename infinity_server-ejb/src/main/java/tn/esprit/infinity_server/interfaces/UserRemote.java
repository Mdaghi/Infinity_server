package tn.esprit.infinity_server.interfaces;	
import java.util.List;

import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.User;

@Remote
public interface UserRemote {

	public User authenticate(String login, String password);
	void CreateUser(User u);
	public boolean checkUniqueLogin(String login);
	public User getUserByLogin(String login);
	public void activateAccount(String login);
	public void desactivateAccount(String login);
	public User getUserById(User user);
	public void updateUser(User user);
	public List<User> getAllClient();
}
