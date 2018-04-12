package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="contact")
public class Contact implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "firstname", nullable = true)
	private String firstName;
	@Column(name = "lastname", nullable = true)
	private String lastName;
	@Column(name = "subject", nullable = true)
	private String subject;
	@Column(name = "content", nullable = true)
	private String content;
	@Column(name = "phonenumber", nullable = true)
	private int phoneNumber;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "contactDate", nullable = true)
	private Date contactDate;
	@Column(name = "birthtDate", nullable = true)
	private java.sql.Date birthDate;
	@Column(name = "answer", nullable = true)
	private String answer;
	@Column(name = "statuts", nullable = true)
	private String statuts;

	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public Date getContactDate() {
		return contactDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public String getAnswer() {
		return answer;
	}
	public String getStatuts() {
		return statuts;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setStatuts(String statuts) {
		this.statuts = statuts;
	}
}
