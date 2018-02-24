package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "NEWS_SOURCE")
public class NewsSource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "URL", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String url;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true, length = 600)
	private String description;
	
	@Column(name = "IMAGE", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	private String image;
	
	@OneToMany(mappedBy="source")
	private List<SubscribeNewsSource> subscribeNewsSource;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
