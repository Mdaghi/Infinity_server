package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NEWS_ARTICLE")
public class NewsArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "AUTHOR", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "TITLE", unique = false, nullable = false, insertable = true, updatable = true, length = 80)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true, length = 80)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "URL", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name = "URL_TO_IMAGE", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	public String getUrlToImage() {
		return urlToImage;
	}
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	@Column(name = "PUBLISH_AT", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	@Override
	public String toString() {
		return "NewsArticle [author=" + author + ", title=" + title + ", description=" + description + ", url=" + url
				+ ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + "]";
	}
    

}
