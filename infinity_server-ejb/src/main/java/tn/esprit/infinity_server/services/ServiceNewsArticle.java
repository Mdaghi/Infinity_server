package tn.esprit.infinity_server.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.NewsArticleRemote;
import tn.esprit.infinity_server.persistence.NewsArticle;
import tn.esprit.infinity_server.persistence.NewsCollection;
import tn.esprit.infinity_server.persistence.NewsSource;
import tn.esprit.infinity_server.persistence.SaveArticle;
import tn.esprit.infinity_server.persistence.User;

@Stateless
@LocalBean
public class ServiceNewsArticle implements NewsArticleRemote {
	
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	
	@Override
	public void addArticle(NewsArticle a)
	{
		em.persist(a);
	}
	public void deleteArticle(NewsArticle a)
	{
		em.remove(a);
	}

	@Override
	public List<NewsArticle> getAllArticles() {
		List <NewsArticle> list = new ArrayList<>();
		TypedQuery<NewsArticle> query = em.createQuery("SELECT na FROM NewsArticle na", NewsArticle.class);
		list = query.getResultList();
		/*try {
			list = articleRequest(source.getUrl());
		} catch (MalformedURLException | UnirestException e) {
            System.out.println("Bad URL: " + source.getUrl());
		}
		*/
		return list;
	}

	@Override
	public List<NewsArticle> getSavedAritcles(User user) {
		List <NewsArticle> list = new ArrayList<>();
		TypedQuery<NewsArticle> query = em.createQuery("SELECT na FROM NewsArticle na INNER JOIN SaveArticle sa WHERE sa.user = :user", NewsArticle.class);
		query.setParameter("user", user);
		list = query.getResultList();
		return list;
	}

	@Override
	public void userSaveArticle(User user, NewsArticle article) {
		SaveArticle sa = new SaveArticle();
		sa.setArticle(article);
		sa.setUser(user);
		sa.setDate(LocalDateTime.now());
		em.merge(sa);
	}

	@Override
	public void userUnSaveArticle(User user, NewsArticle article) {
		SaveArticle sa = new SaveArticle();
		sa.setArticle(article);
		sa.setUser(user);
		em.remove(sa);
	}
	

}

