package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "zerocouponbond")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class ZeroCouponBond extends Bond implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "interestRate", nullable = false)
	private double interestRate;
}
