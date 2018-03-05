package tn.esprit.infinity_server.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infinity_server.interfaces.WatchListsBondsRemote;
import tn.esprit.infinity_server.persistence.BondsOffers;
import tn.esprit.infinity_server.persistence.WatchList;
import tn.esprit.infinity_server.persistence.WatchListBonds;
import tn.esprit.infinity_server.persistence.WatchListBondsPk;
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
		wbpk.setFollowSince(date);
		WatchListBonds wlb=new WatchListBonds();
		wlb.setWatchlistBondPk(wbpk);
		em.persist(wlb);
		
	}

	@Override
	public List<WatchListBonds> readAllWatchlistsBondsUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWatchListBonds(WatchListBonds watchlistsBonds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWatchListsBonds(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WatchList searchWatchListsBonds(WatchListBonds watchlistsBonds) {
		// TODO Auto-generated method stub
		return null;
	}

}
