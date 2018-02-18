package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.infinity_server.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
