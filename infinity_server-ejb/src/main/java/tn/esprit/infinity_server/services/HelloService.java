package tn.esprit.infinity_server.services;

import javax.ejb.Stateless;

import tn.esprit.infinity_server.interfaces.IhelloServiceRemote;
@Stateless
public class HelloService implements IhelloServiceRemote {

	@Override
	public String Hello(String msg) {
		return msg;
	}

}
