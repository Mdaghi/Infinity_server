package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "NEWS_SOURCE")
public class NewsSource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "TITLE", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String title;
	
	@Column(name = "URL", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String url;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true, length = 600)
	private String description;
	
	@Column(name = "IMAGE", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String image;
	
	@OneToMany(mappedBy="source", cascade = CascadeType.ALL)
	private List<SubscribeNewsSource> subscribeNewsSource;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public List<SubscribeNewsSource> getSubscribeNewsSource() {
		return subscribeNewsSource;
	}

	public void setSubscribeNewsSource(List<SubscribeNewsSource> subscribeNewsSource) {
		this.subscribeNewsSource = subscribeNewsSource;
	}

	@Override
	public String toString() {
		return "NewsSource [id=" + id + ", url=" + url + ", description=" + description + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsSource other = (NewsSource) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
