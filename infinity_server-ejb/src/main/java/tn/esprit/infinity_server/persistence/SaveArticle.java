package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "SAVE_ARTICLE")
public class SaveArticle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ID_NEWS_ARTICLE", referencedColumnName = "ID")
	private NewsArticle article;
	
	@ManyToOne
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID")
	private User user;
	
	@Column(name = "DATE", unique = false, nullable = true, insertable = false, updatable = false)
	private LocalDateTime date;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public NewsArticle getArticle() {
		return article;
	}
	public void setArticle(NewsArticle article) {
		this.article = article;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "SaveArticle [id=" + id + ", article=" + article + ", user=" + user + ", date=" + date + "]";
	}
	
}
