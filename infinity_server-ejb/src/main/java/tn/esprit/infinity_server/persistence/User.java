package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@DiscriminatorValue("User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	// firstname
	@Column(name = "firstname", nullable = true, length = 50)
	private String firstname;

	// lastname
	@Column(name = "lastname", nullable = true, length = 50)
	private String lastname;

	// login
	@Column(name = "login", nullable = true, length = 50, unique = true)
	private String login;

	// password
	@Column(name = "password", nullable = true, length = 50)
	private String password;

	// activate
	@Column(name = "activate", nullable = true)
	private int activate;

	// code
	@Column(name = "code", nullable = true, length = 50)
	private String code;

	// phoneNumber
	@Column(name = "phoneNumber", nullable = true, length = 9)
	private String phoneNumber;

	// email
	@Column(name = "email", nullable = true, length = 50)
	private String email;

	// address
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SaveArticle> saveArticles;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SubscribeNewsSource> subscribeNewsSource;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActivate() {
		return activate;
	}

	public void setActivate(int activate) {
		this.activate = activate;
	}

	@Override
	public String toString() {
		String Res ="";
		 Res+="User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", login=" + login
				+ ", password=" + password + ", activate=" + activate + ", code=" + code + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", address=" + address + "]";
		 Res+="\n";
		 return Res;
	}

	public List<SaveArticle> getSaveArticles() {
		return saveArticles;
	}

	public void setSaveArticles(List<SaveArticle> saveArticles) {
		this.saveArticles = saveArticles;
	}

	
	public List<SubscribeNewsSource> getSubscribeNewsSource() {
		return subscribeNewsSource;
	}

	public void setSubscribeNewsSource(List<SubscribeNewsSource> subscribeNewsSource) {
		this.subscribeNewsSource = subscribeNewsSource;
	}


}
