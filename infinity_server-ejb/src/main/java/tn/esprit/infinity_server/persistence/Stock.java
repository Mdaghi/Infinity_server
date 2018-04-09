package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "SYMBOL", nullable = false, unique = false, insertable = true, updatable = true, length = 10)
	private String symbol;
	@Column(name = "NAME", nullable = false, unique = false, insertable = true, updatable = true, length = 100)
	private String name;
	@Column(name = "OPEN", nullable = false)
	private float open;
	@Column(name = "HIGH", nullable = false)
	private float high;
	@Column(name = "LOW", nullable = false)
	private float low;
	@Column(name = "CLOSE", nullable = false)
	private float close;
	@Column(name = "VOLUME", nullable = false)
	private long volume;
	@Column(name = "VARIATION", nullable = false)
	private float variation;
	@Column(name = "COMMENT", nullable = true, unique = false, insertable = true, updatable = true, length = 500)
	private String comment;
	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public float getVariation() {
		return variation;
	}

	public void setVariation(float variation) {
		this.variation = variation;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
