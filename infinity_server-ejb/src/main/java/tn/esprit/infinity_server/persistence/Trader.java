package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.infinity_server.persistence.User;

/**
 * Entity implementation class for Entity: Trader
 *
 */
@Entity
@DiscriminatorValue("Trader")
public class Trader extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	// role
	@Column(name = "grade")
	private Integer grade;
	// experience Year
	@Column(name = "experienceYear")
	private Integer experienceYear;

	@OneToMany(mappedBy = "trader")
	private List<Client> clients;

	@OneToMany(mappedBy = "trader" , cascade={CascadeType.ALL})
	private List<BondsOffers> bondsoffers ;
	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(Integer experienceYear) {
		this.experienceYear = experienceYear;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Trader() {
		super();
	}

}
