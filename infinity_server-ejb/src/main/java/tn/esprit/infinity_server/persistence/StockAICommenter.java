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
@Table(name = "STOCKAICOMMENTER")
public class StockAICommenter {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "COMMENT", nullable = true, unique = false, insertable = true, updatable = true, length = 500)
	private String comment;
	@ManyToOne
	private Stock stock;

	public StockAICommenter(int id, String comment, Stock stock) {
		this.id = id;
		this.comment = comment;
		this.stock = stock;
	}

	public StockAICommenter() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
}
