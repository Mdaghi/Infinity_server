package tn.esprit.infinity_server.interfaces;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.infinity_server.persistence.Stock;
import tn.esprit.infinity_server.persistence.StockAICommenter;

@Remote
public interface StockRemote {
	public void addStock(Stock s);
	public void updateStock(Stock s);
	public void deleteStock(Stock s);
	public List<Stock> getAllStock();
	public StockAICommenter getStockAiCommenter(Stock s);
	public void generateStockComment(StockAICommenter s, Stock stock);
	public boolean hasNonDefaultComment(Stock s);
}
