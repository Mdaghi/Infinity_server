package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class WatchlistsBond implements Serializable {
	
	
	@Id
	private int id;
	private String Name;
	@Column(nullable = true)
	private Integer idBond;
	
	
	public WatchlistsBond(int id, String name, Integer idBond) {
		this.id = id;
		Name = name;
		this.idBond = idBond;
	}
	public WatchlistsBond() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getIdBond() {
		return idBond;
	}
	public void setIdBond(Integer idBond) {
		this.idBond = idBond;
	}
	@Override
	public String toString() {
		return "WatchlistsBond [id=" + id + ", Name=" + Name + ", idBond=" + idBond + "]";
	}
	
	
	
	
	
}
