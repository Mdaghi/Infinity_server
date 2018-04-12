package tn.esprit.infinity_server.interfaces;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface BondsOffers { 
	
	public void addBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers , int idtrader );
	public void addBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers);
	public void updateBondsOffers(tn.esprit.infinity_server.persistence.BondsOffers bondsoffers);
	public void removeBondsOffers(int id);
	BondsOffers findBondsOfferById(Integer id);
	List<tn.esprit.infinity_server.persistence.BondsOffers> findAllBondsOffers();
	List<tn.esprit.infinity_server.persistence.BondsOffers> findBonds(String rech);
	public tn.esprit.infinity_server.persistence.BondsOffers getofferbond(int id1);
	public long getSommePrice3();
	public long getSommePrice4();
	public Integer totalOfBonds();
	public Float maxCouponRate();
	public Float minCouponRate();
	public java.sql.Date minIssueDate();
	
	
}
