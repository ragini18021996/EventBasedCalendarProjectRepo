package com.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Client;
import com.entities.Events;

@Repository(value="eventDao")
@Transactional
public class EventDaoImpl implements EventDao{

	@Autowired
	SessionFactory sf;
	public boolean addEvent(Events c) {
		
		try {
			
			Session session=sf.getCurrentSession();
			
			session.persist(c);
			return true;
			
		}
		catch(Exception e) {e.printStackTrace();}
		
		return false;
	}

	public Events viewEvent(int id) {
		
		try {
			Session session=sf.getCurrentSession();
			Events cat=session.get(Events.class, id);
			
			return cat;
			
			}
			catch(Exception e) {e.printStackTrace();}
			return null;
	}

	public List<Events> viewAllEventsById(int cid) {
		try {
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from Events where cli.clientId =:x order by startTimeDate");
			q.setParameter("x", cid);
			return q.getResultList();
			
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
		
	}

	public boolean deleteEvent(int eventId) {
		try
		{
			Session session=sf.getCurrentSession();
			Events e=new Events();
			e.setEventId(eventId);
			session.delete(e);
			return true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
}
