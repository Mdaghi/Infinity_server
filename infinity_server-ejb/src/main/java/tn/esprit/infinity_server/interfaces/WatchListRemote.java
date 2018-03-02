package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.WatchList;

@Remote
public interface WatchListRemote {
	public void createWatchList(WatchList watchlist);
	public List<WatchList> readAllWatchlistsUser();
	public void updateWatchList(WatchList watchlist);
	public void deleteWatchList(WatchList watchlist);
	public WatchList searchWatchList(WatchList watchlist);

}
