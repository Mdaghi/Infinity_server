package tn.esprit.infinity_server.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infinity_server.persistence.Address;

@Remote
public interface AddressRemote {
	public void CreateAddress(Address a);
	public void UpdateAddress(Address a);
	public void RemoveAddress(Address a);
	Address findAddressById(Integer id);
	List<Address> findAllAddress();

}
