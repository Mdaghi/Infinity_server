package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "bond")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bond implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "startdate", nullable = false)
	private LocalDateTime startDate;
	@Column(name = "maturitydate", nullable = false)	
	private LocalDateTime maturityDate;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "numberofshares", nullable = false)
	private int numberOfShares;
	@Column(name = "priceofshare", nullable = false)
	private double priceOfShare;
	
}
