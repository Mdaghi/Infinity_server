package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "NEWS_SOURCE")
public class NewsSource implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String url;
	private String description;
	private String image;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "URL", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true, length = 600)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IMAGE", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
