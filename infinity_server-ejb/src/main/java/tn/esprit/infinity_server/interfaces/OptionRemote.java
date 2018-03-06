package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import tn.esprit.infinity_server.persistence.OptionPut;

@Remote
public interface OptionRemote {

	public void createPutOption(OptionPut o);
	public void deleteOption(int IdOption);
	public List <OptionPut> ListOptionPut(String c);
	public Long findOptionPutByCode(String c);
	public OptionPut getOptionById(int id);
	
}
