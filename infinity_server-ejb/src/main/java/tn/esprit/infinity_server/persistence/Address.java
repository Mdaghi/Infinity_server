package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	// street
	@Column(name = "street", nullable = true, length = 50)
	private String street;

	// Country
	@Column(name = "country", nullable = true, length = 50)
	private String country;

	// number
	@Column(name = "number", nullable = true)
	private int number;

	// city
	@Column(name = "city", nullable = true, length = 50)
	private String city;

	// postalCode
	@Column(name = "postalCode", nullable = true, length = 50)
	private String postalCode;

	private static final long serialVersionUID = 1L;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", country=" + country + ", number=" + number + ", city="
				+ city + ", postalCode=" + postalCode + "]";
	}
	
	

}
