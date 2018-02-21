package tn.esprit.infinity_server.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencyAccount")
public class CurrencyAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	// amount
	@Column(name = "amount", nullable = true)
	private float amount;
	// active
	@Column(name = "active", nullable = true)
	private boolean active;
	// currency
	@Column(name = "currency", nullable = true)
	private String currency;

}
