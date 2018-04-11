package tn.esprit.infinity_server.interfaces;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.Symbole;


@Remote
public interface SymboleServiceRemote {

	public void createSymbole(Symbole s);
	public void updateSymbole(Symbole s);
	public void removeSymbole(int id);
	Symbole findSymboleById(Integer id);
	List<Symbole> findAllSymbole();
	List<Symbole> searchDynamiqueSymbole(String name);
	public void updateSymboleByid(Symbole s);
	public String allListSymbole();
	public String listSymbolebyName(String name);
	public boolean checkUniqueSymbole(String symbole);
	public List<Symbole> findAll(int page);
	public List<Symbole> findBycritere(String symbole, int page);
	public long countSymbole();
	public long countSymboleByCritere(String critere);
	public Symbole getSymboleByName(String name);

}
