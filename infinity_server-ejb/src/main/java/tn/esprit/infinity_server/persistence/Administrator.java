package tn.esprit.infinity_server.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.infinity_server.persistence.User;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
public class Administrator extends User implements Serializable {

	private String role;
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
