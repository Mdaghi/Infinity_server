package tn.esprit.infinity_server.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



import tn.esprit.infinity_server.interfaces.FutureContractServiceLocal;
import tn.esprit.infinity_server.interfaces.FutureContractServiceRemote;
import tn.esprit.infinity_server.persistence.FutureContract;


/**
 * Session Bean implementation class FutureContractService
 */
@Stateless
@LocalBean
public class FutureContractService implements FutureContractServiceRemote, FutureContractServiceLocal {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;


	@Override
	public void createFutureContract(FutureContract future) {
		em.persist(future);
		
	}

	@Override
	public void updateFutureContract(FutureContract future) {
		em.merge(future);	
	}

	@Override
	public void removeFutureContract(int id) {
		FutureContract f = em.find(FutureContract.class,id);
		em.remove(f);	
	}

	@Override
	public FutureContract findFutureContractById(Integer id) {
		FutureContract found = null;
		String jpql = "select f from FutureContract f where f.id=:id";
		TypedQuery<FutureContract> query = em.createQuery(jpql, FutureContract.class);
		query.setParameter("id", id);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(FutureContractService.class.getName()).log(Level.WARNING, "no such id=" + id);
		}
		return found;
	}

	@Override
	public List<FutureContract> findAllFutureContract() {
		List<FutureContract> resultList = null;
		String jpql = "select f from FutureContract f ";
		TypedQuery<FutureContract> query = em.createQuery(jpql, FutureContract.class);
		try {
			resultList = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "Exception : "+ex);
		}
		return resultList;
	}

	@Override
	public List<FutureContract> searchDynamiqueFutureContract(String name) {
		List<FutureContract> resultList = null;
		String jpql = "select s from FutureContract s WHERE s.name LIKE :name ";
		TypedQuery<FutureContract> query = em.createQuery(jpql, FutureContract.class);
		query.setParameter("name","%"+name+"%");
		try {
			resultList = query.getResultList();
		} catch (Exception ex) {
			Logger.getLogger(SymboleService.class.getName()).log(Level.WARNING, "no such name=" + name);
		}
		return resultList;
	}
}
