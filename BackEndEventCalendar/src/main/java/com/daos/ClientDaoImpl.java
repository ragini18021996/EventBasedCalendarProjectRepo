package com.daos;

import java.util.List;

import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Client;


@Repository(value="clientDao")
@Transactional
public class ClientDaoImpl implements ClientDao{

	@Autowired
	SessionFactory sf;
	public boolean addClient(Client c) {
		
		try {
			
			Session session=sf.getCurrentSession();
			
			session.persist(c);
			return true;
			
		}
		catch(Exception e) {e.printStackTrace();}
		
		return false;
	}


	public Client viewClient(int id) {
		
		try {
			Session session=sf.getCurrentSession();
			Client cat=session.get(Client.class, id);
			
			return cat;
			
			}
			catch(Exception e) {e.printStackTrace();}
			return null;
	}

	
	public List<Client> getAllClient() {
		
		try {
			Session session=sf.getCurrentSession();
			Query<Client> q=session.createQuery("from Client");
			return q.getResultList();
			
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

	public boolean delClient(int clientId) {
		
		try {
			Session session=sf.getCurrentSession();
			Client cat=session.get(Client.class, clientId);
				session.delete(cat);
				return true;
			
			}
			catch(Exception e) {e.printStackTrace();}
			
		
		return false;
	}

	public boolean updateClient(Client c) {
		try {
			Session session=sf.getCurrentSession();
			
				session.update(c);
				return true;
			}
					
		catch(Exception e) {e.printStackTrace();}
		return false;
	}
	public Client getClientById(int clientId)
	{
		try {
			Session session=sf.getCurrentSession();
			Client c=session.get(Client.class, clientId);
			return c;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
