package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "NEWS_ARTICLE")
public class NewsArticle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "AUTHOR", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	private String author;
	
	@Column(name = "TITLE", unique = false, nullable = false, insertable = true, updatable = true, length = 500)
	private String title;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true, length = 500)
	private String description;
	
	@Column(name = "URL", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String url;
	
	@Column(name = "URL_TO_IMAGE", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String urlToImage;
	
	@Column(name = "PUBLISH_AT", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String publishedAt;

	@OneToMany(mappedBy="article", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SaveArticle> saveArticles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	
	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public List<SaveArticle> getSaveArticles() {
		return saveArticles;
	}

	public void setSaveArticles(List<SaveArticle> saveArticles) {
		this.saveArticles = saveArticles;
	}

	@Override
	public String toString() {
		return "NewsArticle [author=" + author + ", title=" + title + ", description=" + description + ", url=" + url
				+ ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + "]";
	}

}
