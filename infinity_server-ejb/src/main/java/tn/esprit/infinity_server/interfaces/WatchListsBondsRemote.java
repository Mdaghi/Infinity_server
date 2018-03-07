package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.WatchList;
import tn.esprit.infinity_server.persistence.WatchListBonds;

@Remote
public interface WatchListsBondsRemote {
	public void createWatchListsBonds(int idBondOffer,int idWatchList);
	public List<WatchListBonds> readAllWatchlistsBondsUser();
	public void updateWatchListBonds(WatchListBonds watchlistsBonds);
	public void deleteWatchListsBonds(int id);
	public WatchList searchWatchListsBonds(WatchListBonds watchlistsBonds);
}
