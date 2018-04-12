package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "claim")
public class Claim implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "dateClaim")
	private LocalDate dateClaim;
    @ManyToOne
    private Client client;
    public LocalDate getDateClaim() {
		return dateClaim;
	}
	public void setDateClaim(LocalDate dateClaim) {
		this.dateClaim = dateClaim;
	}
	@ManyToOne
    private Trader trader;
	// description
	@Column(name = "description", nullable = true, length = 255)
	private String description;
	// status
	@Column(name = "status", nullable = true, length = 255)
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
