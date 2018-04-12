package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Claim;

@Remote
public interface ClaimRemote {

	
	public int ajouterClaim(Claim claim);
	public void deleteClaim(Claim claim);
	public void deleteClaim (int iddem);
	public List<Claim> getClaims();
	public List<Claim> getClaimsforAdmin();
	public void updateClaim(Claim d);
	public int getNbreClaim();
}
