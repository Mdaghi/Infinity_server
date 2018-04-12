package tn.esprit.infinity_server.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.WatchListsBondsRemote;
import tn.esprit.infinity_server.persistence.BondsOffers;
import tn.esprit.infinity_server.persistence.WatchList;
import tn.esprit.infinity_server.persistence.WatchListBonds;
import tn.esprit.infinity_server.persistence.WatchListBondsPk;
import tn.esprit.infinity_server.persistence.WatchlistsBond;
@Stateless
public class WatchListsBondsService implements WatchListsBondsRemote{

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;	
	@Override
	public void createWatchListsBonds(int idBondOffer,int idWatchList) {
		WatchList watchList=em.find(WatchList.class, idWatchList);
		BondsOffers bondsOffers=em.find(BondsOffers.class, idBondOffer);
		WatchListBondsPk wbpk=new WatchListBondsPk();
		Date date =new Date();
		wbpk.setIdBond(idBondOffer);
		wbpk.setIdWatchlist(idWatchList);
		WatchListBonds wlb=new WatchListBonds();
		wlb.setFollowSince(date);
		wlb.setWatchlistBondPk(wbpk);
		em.persist(wlb);
		
	}


	@Override
	public void updateWatchListBonds(WatchListBonds watchlistsBonds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWatchListsBonds(int idBond,int idWatchList) {
		TypedQuery<WatchListBonds> delete=(TypedQuery<WatchListBonds>) em.createNativeQuery("Delete from WatchListBonds where idBond=? and idWatchList=?",WatchListBonds.class);
		delete.setParameter(1, idBond);
		delete.setParameter(2, idWatchList);
		delete.executeUpdate();	
	}

	@Override
	public WatchList searchWatchListsBonds(WatchListBonds watchlistsBonds) {
		//no need for now
		return null;
	}

	@Override
	public List<WatchListBonds> readAllWatchlistsBondsUser(int idWatchList) {
		Query query= em.createQuery("from WatchListBonds where idWatchList=:idWatchList", WatchListBonds.class);
		query.setParameter("idWatchList",idWatchList);
		return query.getResultList();
	}


	@Override
	public tn.esprit.infinity_server.persistence.BondsOffers readBondOffer(int id) {
		return em.find(tn.esprit.infinity_server.persistence.BondsOffers.class, id);
	}


	
	@Override
	public List<WatchlistsBond> readWatchListsBond(int bond, int idClient) {	
		TypedQuery<WatchlistsBond> query=(TypedQuery<WatchlistsBond>) em.createNativeQuery("select w.id,w.name,wb.idBond from watchlist w LEFT JOIN watchlistbonds wb on w.ID=wb.idWatchlist where w.client_id=? UNION select w.id,w.name,wb.idBond from watchlist w RIGHT JOIN watchlistbonds wb on w.ID=wb.idWatchlist where w.client_id=? AND wb.idBond=?",WatchlistsBond.class);
		query.setParameter(1, idClient);
		query.setParameter(2, idClient);
		query.setParameter(3, bond);
		return query.getResultList();
	}

	
}
