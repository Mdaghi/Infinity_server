package tn.esprit.infinity_server.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.NewsSourceRemote;
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
		list=  em.createQuery("SELECT NS FROM " + NewsSource.class.getName() + " NS", NewsSource.class)
				.getResultList();
		return list;
	}

	@Override
	public List<NewsSource> getSubscribedNewsSource(User user) {
		TypedQuery<SubscribeNewsSource> query = em.createQuery("SELECT SN FROM " + SubscribeNewsSource.class.getName() + " SN where user=:user",SubscribeNewsSource.class);
		query.setParameter("user", user);
		List<SubscribeNewsSource> list = query.getResultList();
		List<NewsSource> listNewsSource = new ArrayList<>();
		list.forEach(sc -> {
			listNewsSource.add(sc.getSource());
		});
		return listNewsSource;
	}

	@Override
	public SubscribeNewsSource getSelecteddNewsSource(User user) {
		TypedQuery<SubscribeNewsSource> query = em.createQuery("SELECT SN FROM " + SubscribeNewsSource.class.getName() + " SN where user=:user and selected=:selected",SubscribeNewsSource.class);
		query.setParameter("user", user);
		query.setParameter("selected", true);
		try
		{
		return query.getSingleResult();
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public void selectNewsSource(User user, NewsSource source) {
		SubscribeNewsSource snSelected;
		try
		{
		snSelected = getSelecteddNewsSource(user);
		snSelected.setSelected(false);
		em.merge(snSelected);
		}
		catch(NullPointerException e)
		{
			System.out.println("None selected");
		}
		SubscribeNewsSource sn = new SubscribeNewsSource();
		TypedQuery<SubscribeNewsSource> query = em.createQuery("SELECT SN FROM SubscribeNewsSource SN where source=:source and user=:user and selected=:selected", SubscribeNewsSource.class);
		query.setParameter("user", user);
		query.setParameter("source", source);
		query.setParameter("selected", false);
		sn = query.getSingleResult();
		sn.setSelected(true);
		em.merge(sn);
		em.flush();
	}

	@Override
	public void unselectNewsSource(User user, NewsSource source) {
		SubscribeNewsSource sn = new SubscribeNewsSource();
		TypedQuery<SubscribeNewsSource> query = em.createQuery("SELECT SN FROM SubscribeNewsSource SN where source=:source and user=:user and selected=:selected",  SubscribeNewsSource.class);
		query.setParameter("user", user);
		query.setParameter("source", source);
		query.setParameter("selected", true);

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
		em.merge(sns);	
	}
	
	@Override
	public void userUnSubscribeNewsSource(User user, NewsSource source) {
		SubscribeNewsSource sns = new SubscribeNewsSource();
		sns.setSource(source);
		sns.setUser(user);
		em.remove(sns);	
	}

	@Override
	public void addNewsSource(NewsSource ns) {
		em.merge(ns);
	}

	@Override
	public void updateNewsSource(NewsSource ns) {
		em.merge(ns);
	}

	@Override
	public void deleteNewsSource(NewsSource ns)
	{
		em.remove(em.contains(ns) ? ns : em.merge(ns));
	}

	@Override
	public void testAddUser(User user) {
		em.merge(user);
	}

}