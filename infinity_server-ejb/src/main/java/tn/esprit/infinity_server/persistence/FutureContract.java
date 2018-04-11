package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "futureContract")
public class FutureContract implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6725337312442390273L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "maturityPrice", nullable = false)
	private Double maturityPrice;
	@Column(name = "DateMaturite", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateMaturite;
	@Column(name = "size", nullable = false)
	private Integer size;
	@OneToOne
	private Symbole symbole;
	
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
	public Double getMaturityPrice() {
		return maturityPrice;
	}
	public void setMaturityPrice(Double maturityPrice) {
		this.maturityPrice = maturityPrice;
	}
	
	public Date getDateMaturite() {
		return dateMaturite;
	}
	public void setDateMaturite(Date dateMaturite) {
		this.dateMaturite = dateMaturite;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Symbole getSymbole() {
		return symbole;
	}
	public void setSymbole(Symbole symbole) {
		this.symbole = symbole;
	}
		
	

}
