package tn.esprit.infinity_server.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SUBSCRIBE_NEWS_SOURCE")
public class SubscribeNewsSource implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private NewsSource source;
	private User user;
	private boolean selected=false;

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
	@JoinColumn(name = "ID_NEWS_SOURCE", referencedColumnName = "ID", insertable = false, updatable = false)
	public NewsSource getSource() {
		return source;
	}

	public void setSource(NewsSource source) {
		this.source = source;
	}

	@ManyToOne
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "SELECTED")
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	

}
