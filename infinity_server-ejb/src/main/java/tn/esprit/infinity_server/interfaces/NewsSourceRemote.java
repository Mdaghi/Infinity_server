package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.NewsSource;
import tn.esprit.infinity_server.persistence.User;

@Remote
public interface NewsSourceRemote {
	public List<NewsSource> getAllNewsSource();
	public List<NewsSource> getSubscribedNewsSource(User user);
	public void userSubscribeNewsSource(User user, NewsSource source);
	public void selectNewsSource(User user, NewsSource source);
	public void unselectNewsSource(User user, NewsSource source);
}
