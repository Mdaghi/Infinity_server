package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.WatchList;

@Remote
public interface WatchListRemote {
	public void createWatchList(WatchList watchlist,int idClient);
	public List<WatchList> readAllWatchlistsUser(int idClient);
	public void updateWatchList(WatchList watchlist);
	public void deleteWatchList(int id);
	public List<WatchList> searchWatchList(String watchlist,int idClient);

}
