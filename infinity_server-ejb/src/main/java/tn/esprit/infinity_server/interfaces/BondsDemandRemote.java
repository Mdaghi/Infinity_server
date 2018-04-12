package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.infinity_server.persistence.DemandeBond;

@Remote
public interface BondsDemandRemote {
	public int ajouterDemande(DemandeBond demande);
	public void deletedemande(DemandeBond demande);
	public void deletedemande (int iddem);
	public List<DemandeBond> getDemandeBond();
	public void updateDemande(DemandeBond d);
	public int getNbreDemande();
	public DemandeBond getdemandebond(int id);
	public double getSommePrice();
	public double getSommePrice2();
}
