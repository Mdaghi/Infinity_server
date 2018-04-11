package tn.esprit.infinity_server.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.WatchListRemote;
import tn.esprit.infinity_server.persistence.Client;
import tn.esprit.infinity_server.persistence.WatchList;
@Stateless
public class WatchListService implements WatchListRemote{
	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;	
	@Override
	public void createWatchList(WatchList watchlist,int idClient) {
		Client client=em.find(Client.class, idClient);
		watchlist.setClient(client);
		em.persist(watchlist);
	}

	@Override
	public List<WatchList> readAllWatchlistsUser(int idClient) {
		Query query= em.createQuery("from WatchList where client_id=:idClient", WatchList.class);
			query.setParameter("idClient",idClient);
			return query.getResultList();

	}

	@Override
	public void updateWatchList(WatchList watchlist) {
 		Query query=em.createQuery("Update WatchList w set name=:name,description=:description where w.id=:id");
		query.setParameter("name",watchlist.getName());
		query.setParameter("description",watchlist.getDescription());
		query.setParameter("id",watchlist.getId());
		query.executeUpdate();		
	}

	@Override
	public void deleteWatchList(int id) {
		WatchList w=em.find(WatchList.class, id);
		em.remove(w);		
	}

	@Override
	public List<WatchList> searchWatchList(String watchlist,int idClient) {
		Query query=em.createQuery("select b from WatchList b where b.name like :name or b.Description like :description");
		query.setParameter("name",watchlist);
		query.setParameter("description",watchlist);
		return query.getResultList();
	}

}
