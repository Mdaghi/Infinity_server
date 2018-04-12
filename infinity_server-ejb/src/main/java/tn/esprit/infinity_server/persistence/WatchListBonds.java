package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private BondsOffers bond;
	@ManyToOne
	@JoinColumn(name="IDWATCHLIST",referencedColumnName="ID",insertable=false,updatable=false)
	private WatchList watchList;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "followSince")	
	private Date followSince;
	
	public WatchListBondsPk getWatchlistBondPk() {
		return watchlistBondPk;
	}
	public void setWatchlistBondPk(WatchListBondsPk watchlistBondPk) {
		this.watchlistBondPk = watchlistBondPk;
	}
	
	public Date getFollowSince() {
		return followSince;
	}
	public void setFollowSince(Date followSince) {
		this.followSince = followSince;
	}
	
	
	public BondsOffers getBond() {
		return bond;
	}

	public void setBond(BondsOffers bond) {
		this.bond = bond;
	}

	public WatchList getWatchList() {
		return watchList;
	}

	public void setWatchList(WatchList watchList) {
		this.watchList = watchList;
	}

	
	
	
	
	
	

}
