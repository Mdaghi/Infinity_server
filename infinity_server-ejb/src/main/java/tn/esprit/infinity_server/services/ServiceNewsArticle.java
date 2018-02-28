package tn.esprit.infinity_server.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

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
	public List<NewsArticle> getAllArticles() {
		List <NewsArticle> list = new ArrayList<>();
		TypedQuery<NewsArticle> query = em.createQuery("SELECT na FROM NewsArticle na", NewsArticle.class);
		list = query.getResultList();
		/*try {
			list = articleRequest(source.getUrl());
		} catch (MalformedURLException | UnirestException e) {
            System.out.println("Bad URL: " + source.getUrl());
		}*/
		
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
		em.persist(sa);
		em.flush();
	}

	@Override
	public void userUnSaveArticle(User user, NewsArticle article) {
		SaveArticle sa = new SaveArticle();
		sa.setArticle(article);
		sa.setUser(user);
		em.remove(sa);
		em.flush();
	}
	
    /*static List<NewsArticle> articleRequest(String url) throws UnirestException, MalformedURLException {
       /* final HttpResponse<String> stringHttpResponse;
        // This will throw MalformedURLException if the url is malformed.
        new URL(url);
        stringHttpResponse = Unirest.get(url).asString();
        // Check to see if the request was successful; if so, convert the payload JSON into Java objects
        if (stringHttpResponse.getStatus() == STATUS_OK) {
            String json = stringHttpResponse.getBody();
            Gson gson = new Gson();
            final NewsCollection newsCollection = gson.fromJson(json, NewsCollection.class);
            return newsCollection.getArticles();
        }
		return null;
    }*/


}

