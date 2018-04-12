package tn.esprit.infinity_server.interfaces;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Affectation;

@Remote
public interface AffectationRemote {
	
	public int ajouterAffectation(int offid,int demid,LocalDate dateBond, LocalDate issueDate,LocalDate matureDate,Double price,Double couponRate );
	public void deleteAffectation(Affectation affectation);
	public void deleteAffectation (int iddem);
	public List<Affectation> getAffectation();
	public void updateAffectation(Affectation d);
	public int getNbreAffectation();

}
