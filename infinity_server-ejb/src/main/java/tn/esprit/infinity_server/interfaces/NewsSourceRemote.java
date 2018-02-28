package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.*;

@Remote
public interface NewsSourceRemote {
	public List<NewsSource> getAllNewsSource();
	public List<NewsSource> getSubscribedNewsSource(User user);
	public void userSubscribeNewsSource(User user, NewsSource source);
	public void selectNewsSource(User user, NewsSource source);
	public void unselectNewsSource(User user, NewsSource source);
	public void addNewsSource(NewsSource ns);
	public void updateNewsSource(NewsSource ns);
	public void deleteNewsSource(NewsSource ns);
}
