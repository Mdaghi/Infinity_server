package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class WatchListBondsPk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idBond;
	private int idWatchlist;
	@Temporal(TemporalType.DATE)
	@Column(name = "followSince")	
	private Date followSince;
	public int getIdBond() {
		return idBond;
	}
	public void setIdBond(int idBond) {
		this.idBond = idBond;
	}
	public int getIdWatchlist() {
		return idWatchlist;
	}
	public void setIdWatchlist(int idWatchlist) {
		this.idWatchlist = idWatchlist;
	}
	public Date getFollowSince() {
		return followSince;
	}
	public void setFollowSince(Date followSince) {
		this.followSince = followSince;
	}
	
	
	
	
	/**********HashSetAnd Equal*********/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((followSince == null) ? 0 : followSince.hashCode());
		result = prime * result + idBond;
		result = prime * result + idWatchlist;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WatchListBondsPk other = (WatchListBondsPk) obj;
		if (followSince == null) {
			if (other.followSince != null)
				return false;
		} else if (!followSince.equals(other.followSince))
			return false;
		if (idBond != other.idBond)
			return false;
		if (idWatchlist != other.idWatchlist)
			return false;
		return true;
	}
	
}
