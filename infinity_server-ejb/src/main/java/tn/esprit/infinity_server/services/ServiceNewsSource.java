package tn.esprit.infinity_server.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.NewsSourceRemote;
import tn.esprit.infinity_server.persistence.Address;
import tn.esprit.infinity_server.persistence.NewsSource;
import tn.esprit.infinity_server.persistence.SubscribeNewsSource;
import tn.esprit.infinity_server.persistence.User;

@Stateless
@LocalBean
public class ServiceNewsSource implements NewsSourceRemote {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	@Override
	public List<NewsSource> getAllNewsSource() {
		List<NewsSource> list = new ArrayList<>();
		list=  em.createQuery("select a from NewsSource a", NewsSource.class)
				.getResultList();
		return list;
	}

	@Override
	public List<NewsSource> getSubscribedNewsSource(User user) {
		//List<NewsSource> list = em.createQuery("SELECT NS, U FROM NewsSource NS INNER JOIN c1.neighbors c2").getResultList();
		return null;
	}

	@Override
	public void selectNewsSource(User user, NewsSource source) {
		SubscribeNewsSource sn = new SubscribeNewsSource();
		TypedQuery<SubscribeNewsSource> query = em.createQuery("SELECT SN FROM SubscribeNewsSource SN where source=:source and user=:user", SubscribeNewsSource.class);
		query.setParameter("user", user);
		query.setParameter("source", source);
		sn = query.getSingleResult();
		sn.setSelected(true);
		em.persist(sn);
		em.flush();
	}

	@Override
	public void unselectNewsSource(User user, NewsSource source) {
		SubscribeNewsSource sn = new SubscribeNewsSource();
		TypedQuery<SubscribeNewsSource> query = em.createQuery("SELECT SN FROM SubscribeNewsSource SN where source=:source and user=:user", SubscribeNewsSource.class);
		query.setParameter("user", user);
		query.setParameter("source", source);
		sn = query.getSingleResult();
		sn.setSelected(false);
		em.persist(sn);
		em.flush();		
	}

	@Override
	public void userSubscribeNewsSource(User user, NewsSource source) {
		SubscribeNewsSource sns = new SubscribeNewsSource();
		sns.setSource(source);
		sns.setUser(user);
		em.persist(sns);	
		em.flush();
	}
	
	@Override
	public void addNewsSource(NewsSource ns)
	{
		em.merge(ns);
	}
	
	@Override
	public void deleteNewsSource(NewsSource ns)
	{
		em.remove(ns);
		em.merge(ns);
	}

	@Override
	public void updateNewsSource(NewsSource ns) {
		// TODO Auto-generated method stub
		
	}

}