package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LikePk implements Serializable{
	private int idClient;
	private int idBond;
	
	
	public LikePk() {
		super();
	}


	public LikePk(int idClient, int idBond) {
		super();
		this.idClient = idClient;
		this.idBond = idBond;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public int getIdBond() {
		return idBond;
	}


	public void setIdBond(int idBond) {
		this.idBond = idBond;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBond;
		result = prime * result + idClient;
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
		LikePk other = (LikePk) obj;
		if (idBond != other.idBond)
			return false;
		if (idClient != other.idClient)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LikePk [idClient=" + idClient + ", idBond=" + idBond + "]";
	}
	
	
	
	

}
