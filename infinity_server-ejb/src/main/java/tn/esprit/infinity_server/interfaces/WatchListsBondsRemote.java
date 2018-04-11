package tn.esprit.infinity_server.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.WatchList;
import tn.esprit.infinity_server.persistence.WatchListBonds;
import tn.esprit.infinity_server.persistence.WatchlistsBond;
import tn.esprit.infinity_server.persistence.BondsOffers;


@Remote
public interface WatchListsBondsRemote {
	public void createWatchListsBonds(int idBondOffer,int idWatchList);
	public List<WatchListBonds> readAllWatchlistsBondsUser(int idWatchList);
	public void updateWatchListBonds(WatchListBonds watchlistsBonds);
	public void deleteWatchListsBonds(int idBond,int idWatchList);
	public WatchList searchWatchListsBonds(WatchListBonds watchlistsBonds);
	public BondsOffers readBondOffer(int id);
	public List<WatchlistsBond> readWatchListsBond(int bond,int idWatchList);
}
