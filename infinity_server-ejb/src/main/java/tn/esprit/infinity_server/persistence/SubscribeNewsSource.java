package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SUBSCRIBE_NEWS_SOURCE")
public class SubscribeNewsSource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ID_NEWS_SOURCE", referencedColumnName = "ID", insertable = false, updatable = false)
	private NewsSource source;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID", insertable = false, updatable = false)
	private User user;
	
	@Column(name = "SELECTED")
	private boolean selected=false;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public NewsSource getSource() {
		return source;
	}

	public void setSource(NewsSource source) {
		this.source = source;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	

}
