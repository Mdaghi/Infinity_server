package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "SAVE_ARTICLE")
public class SaveArticle implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private NewsArticle article;
	private User user;
	private LocalDateTime date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "ID_NEWS_ARTICLE", referencedColumnName = "ID", insertable = false, updatable = false)
	public NewsArticle getArticle() {
		return article;
	}
	public void setArticle(NewsArticle article) {
		this.article = article;
	}
	@ManyToOne
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name = "DATE", unique = false, nullable = false, insertable = true, updatable = true)
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
