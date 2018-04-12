package tn.esprit.infinity_server.services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.infinity_server.interfaces.StockRemote;
import tn.esprit.infinity_server.persistence.Stock;
import tn.esprit.infinity_server.persistence.StockAICommenter;
import tn.esprit.infinity_server.persistence.SubscribeNewsSource;

@Stateless
@LocalBean
public class ServiceStock implements StockRemote {

	@PersistenceContext(unitName = "infinity_server-ejb")
	EntityManager em;

	@Override
	public void addStock(Stock s) {
		em.merge(s);		
	}
	
	@Override
	public void updateStock(Stock s)
	{
		em.merge(s);
	}

	@Override
	public void deleteStock(Stock s) {
		em.remove(em.contains(s) ? s : em.merge(s));		
	}

	@Override
	public List<Stock> getAllStock() {
		List<Stock> list = new ArrayList<>();
		list=  em.createQuery("SELECT S FROM " + Stock.class.getName() + " S", Stock.class)
				.getResultList();
		return list;
	}
	
	@Override
	public StockAICommenter getStockAiCommenter(Stock s) {
		StockAICommenter SAC = null;
		try {
		SAC = em.createQuery("SELECT SAC FROM " + StockAICommenter.class.getName() + " SAC where stock=:stock", StockAICommenter.class)
				.setParameter("stock", s)
				.getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println("No result found");
		}
		return SAC;
	}

	@Override
	public void generateStockComment(StockAICommenter s, Stock stock) {
		em.merge(stock);
		em.merge(s);	
	}

	@Override
	public boolean hasNonDefaultComment(Stock s) {
		List<StockAICommenter> list = em.createQuery("SELECT SAC FROM " + StockAICommenter.class.getName() + " SAC where stock=:stock", StockAICommenter.class)
				.setParameter("stock", s)
				.getResultList();
		return !list.isEmpty();
	}


}
