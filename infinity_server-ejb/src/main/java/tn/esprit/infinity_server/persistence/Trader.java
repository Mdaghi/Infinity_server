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
public class Trader extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	// role
	@Column(name = "grade")
	private int grade;
	// experience Year
	@Column(name = "experienceYear")
	private int experienceYear;

	@OneToMany(mappedBy = "trader")
	private List<Client> clients;

	@OneToMany(mappedBy = "trader")
	private List<BondsOffers> bondsoffers ;
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(int experienceYear) {
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
