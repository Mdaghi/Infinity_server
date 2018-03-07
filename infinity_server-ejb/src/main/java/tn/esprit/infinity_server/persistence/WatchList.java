package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class WatchList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3979120002611588436L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATIONDATE", nullable = false)
	private Date creationDate;
	@Column(name = "DESCRIPTION", nullable = true)
	private String Description;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy="watchList")
	private List<WatchListBonds> watchListbonds;

	
	public WatchList() {
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "WatchList [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", Description="
				+ Description +"]";
	}
	
}
