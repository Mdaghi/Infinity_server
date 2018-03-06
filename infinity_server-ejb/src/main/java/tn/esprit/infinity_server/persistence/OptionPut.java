package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date; 
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="OPTION_PUT")
public class OptionPut implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Id
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(name = "DURATION")
	private Date duration ;
	//prix de l'exercice 
	@Column(name = "Strike_PRICE")
	private float strikePrice; 
	// price of the option
	@Column(name = "PRICE_OPTION")
	private float priceOption ; 
	@Column(name = "CODE")
	private String code ;
	@Column(name = "TYPE")
	private String type ;
	@ManyToOne
	private Client client ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public float getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(float strikePrice) {
		this.strikePrice = strikePrice;
	}
	public float getPriceOption() {
		return priceOption;
	}
	public void setPriceOption(float priceOption) {
		this.priceOption = priceOption;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public OptionPut() {
		super();
	}
	public OptionPut(String code) {
		super();
		this.code = code;
	}
	
}
