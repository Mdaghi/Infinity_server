package tn.esprit.infinity_server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.infinity_server.interfaces.SymboleServiceLocal;
import tn.esprit.infinity_server.interfaces.SymboleServiceRemote;
import tn.esprit.infinity_server.persistence.Symbole;

/**
 * Session Bean implementation class SymboleService
 */
@Stateless
@LocalBean
public class SymboleService implements SymboleServiceRemote, SymboleServiceLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;
	


	/**
	 * Default constructor.
	 */
	

	@Override
	public void createSymbole(Symbole s) {
		em.persist(s);
	}

	@Override
	public void updateSymbole(Symbole s) {
		em.merge(s);

	}

	@Override
	public void removeSymbole(int id) {
		Symbole s = em.find(Symbole.class,id);
		em.remove(s);

	}

	@Override
	public Symbole findSymboleById(Integer id) {
		Symbole found = null;
		String jpql = "select s from Symbole s where s.id=:id";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		query.setParameter("id", id);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "no such id=" + id);
		}
		return found;
	}

	@Override
	public  List<Symbole> findAllSymbole() {
		List<Symbole> resultList = null;
		String jpql = "select s from Symbole s ";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		try {
			resultList = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "Exception : "+ex);
		}
		return resultList;
	}

	@Override
	public void updateSymboleByid(Symbole s) {
		String jpql = "update s from Symbole set s.name=:name where s.id=:id";
		Query query = em.createQuery(jpql, Symbole.class);
		query.setParameter("name", s.getId());
		query.setParameter("id", s.getName());
		int modif = query.executeUpdate();
		if (modif == 1)
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "modification ok");
		else
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "modification n'est pas effectue");
	}

	@Override
	public List<Symbole> searchDynamiqueSymbole(String name) {
		List<Symbole> resultList = null;
		String jpql = "select s from Symbole s WHERE s.name LIKE :name ";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		query.setParameter("name","%"+name+"%");
		try {
			resultList = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "no such name=" + name);
		}
		return resultList;
	}
	@Override
	public String allListSymbole() {
		StringBuilder str = new StringBuilder();
		List<Symbole> lst = findAllSymbole();
		for (int i = 0; i < lst.size(); i++) {
			if (i == lst.size() - 1)
				str.append(lst.get(i).getName());
			else
				str.append(lst.get(i).getName()+",") ;
		}
		return str.toString();
	}
	@Override
	public String listSymbolebyName(String name) {
		StringBuilder str = new StringBuilder();
		List<Symbole> lst = searchDynamiqueSymbole(name);
		for (int i = 0; i < lst.size(); i++) {
			if (i == (lst.size() - 1))
				str.append(lst.get(i).getName());
			else
				str.append(lst.get(i).getName()+",") ;
		}
		return str.toString();
	}
	@Override
	public boolean checkUniqueSymbole(String symbole) {
		String jpql = "select s from Symbole s where s.name=:name";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		query.setParameter("name", symbole);
		try {
			if (query.getSingleResult() != null)
				return false;
				
		} catch (Exception ex) {
			return true;
		}
		return true;
	}

	@Override
	public List<Symbole> findAll(int page) {
		long nbr = countSymbole(); 
        long start = 0;
        long nbrpage = (Math.round((float) nbr / 2)+1);
        if(page == nbrpage){
            start = ((page-1)*2); 
        }else{
            start = (page*2);
        }
        List<Symbole> resultList = null;
		String jpql = "select s from Symbole s  ";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		query.setFirstResult((int)start);
		query.setMaxResults(2);
		try {
			resultList = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, " find All list :"+ex);
		}
		return resultList;
        
	}

	@Override
	public long countSymbole() {
		String jpql = "select count(s) from Symbole s ";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		return query.getSingleResult();
	}
	
	@Override
	public long countSymboleByCritere(String critere) {
		String jpql = "select count(s) from Symbole s WHERE s.name LIKE :name";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("name","%"+critere+"%");
		return query.getSingleResult();
	}

	@Override
	public List<Symbole> findBycritere(String symbole, int page) {
		long nbr = countSymboleByCritere(symbole); 
        long start = 0;
        long nbrpage = (Math.round((float) nbr / 2)+1);
        if(page == nbrpage){
            start = ((page-1)*2); 
        }else{
            start = (page*2);
        }
        List<Symbole> resultList = null;
		String jpql = "select s from Symbole s WHERE s.name LIKE :name ";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		query.setParameter("name","%"+symbole+"%");
		query.setFirstResult((int)start);
		query.setMaxResults(2);
		try {
			resultList = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, " find All list :"+ex);
		}
		return resultList;
	}

	@Override
	public Symbole getSymboleByName(String name) {
		String jpql = "select s from Symbole s where s.name=:name";
		TypedQuery<Symbole> query = em.createQuery(jpql, Symbole.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	
	
	

	

}
