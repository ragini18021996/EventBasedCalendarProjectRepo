package com.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entities.Client;


public interface ClientDao {

	public boolean addClient(Client c);
	public Client viewClient(int id);
	public List<Client> getAllClient();
	public boolean delClient(int clientId);
	public boolean updateClient(Client c);
	public Client getClientById(int clientId);
}
