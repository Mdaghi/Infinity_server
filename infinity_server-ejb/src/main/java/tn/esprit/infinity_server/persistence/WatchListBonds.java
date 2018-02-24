package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class WatchListBonds implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private WatchListBondsPk watchlistBondPk;
	@ManyToOne
	@JoinColumn(name="IDBOND",referencedColumnName="id",insertable=false,updatable=false)
	private Bond bond;
	@ManyToOne
	@JoinColumn(name="IDWATCHLIST",referencedColumnName="ID",insertable=false,updatable=false)
	private WatchList watchList;
	
	public WatchListBondsPk getWatchlistBondPk() {
		return watchlistBondPk;
	}

	public Bond getBond() {
		return bond;
	}

	public void setBond(Bond bond) {
		this.bond = bond;
	}

	public WatchList getWatchList() {
		return watchList;
	}

	public void setWatchList(WatchList watchList) {
		this.watchList = watchList;
	}
	
	
	
	
	
	

}
