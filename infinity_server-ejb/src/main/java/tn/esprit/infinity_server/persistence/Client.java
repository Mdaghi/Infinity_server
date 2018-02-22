package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import tn.esprit.infinity_server.persistence.User;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends User implements Serializable {

	// lastConnection
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastConnection", nullable = true)
	private Date lastConnection;

	// isBanned
	@Column(name = "isBanned", nullable = true)
	private int isBanned;

	@OneToMany
	private List<CurrencyAccount> currencies;

	@ManyToOne
	private Trader trader;

	public List<CurrencyAccount> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyAccount> currencies) {
		this.currencies = currencies;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrador(Trader trader) {
		this.trader = trader;
	}

	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	public int getIsBanned() {
		return this.isBanned;
	}

	public void setIsBanned(int isBanned) {
		this.isBanned = isBanned;
	}

	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

}
