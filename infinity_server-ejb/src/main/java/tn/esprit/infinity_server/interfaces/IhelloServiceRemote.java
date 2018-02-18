package tn.esprit.infinity_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface IhelloServiceRemote {

	public String Hello(String msg);
}
