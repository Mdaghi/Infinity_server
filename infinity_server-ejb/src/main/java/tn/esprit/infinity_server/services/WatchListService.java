package tn.esprit.infinity_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.infinity_server.interfaces.WatchListRemote;
import tn.esprit.infinity_server.persistence.WatchList;
@Stateless
public class WatchListService implements WatchListRemote{
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;	
	@Override
	public void createWatchList(WatchList watchlist) {
		em.persist(watchlist);
	}

	@Override
	public List<WatchList> readAllWatchlistsUser() {
		
		return null;
	}

	@Override
	public void updateWatchList(WatchList watchlist) {
 		Query query=em.createQuery("Update WatchList set name=:name,description=:description");
		query.setParameter("name",watchlist.getName());
		query.setParameter("description",watchlist.getDescription());
		//query.setParameter("id", watchlist.getId());

		query.executeUpdate();		
	}

	@Override
	public void deleteWatchList(int id) {
		WatchList w=em.find(WatchList.class, id);
		em.remove(w);		
	}

	@Override
	public WatchList searchWatchList(WatchList watchlist) {
		// TODO Auto-generated method stub
		return null;
	}

}
