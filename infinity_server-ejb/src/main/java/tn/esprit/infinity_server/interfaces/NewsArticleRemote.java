package tn.esprit.infinity_server.interfaces;

import java.net.MalformedURLException;
import java.util.List;
import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.NewsArticle;
import tn.esprit.infinity_server.persistence.NewsSource;
import tn.esprit.infinity_server.persistence.User;

@Remote
public interface NewsArticleRemote {
	public void addArticle(NewsArticle a);
	public void deleteArticle(NewsArticle a);
	public List<NewsArticle> getAllArticles();
	public List<NewsArticle> getSavedAritcles(User user);
	public void userSaveArticle(User user, NewsArticle article);
	public void userUnSaveArticle(User user, NewsArticle article);
}
