package com.daos;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.entities.Events;


@Repository
public interface EventDao {

	public boolean addEvent(Events c);
	public Events viewEvent(int id);
	public List<Events> viewAllEventsById(int cid);
	public boolean deleteEvent(int eventId);
	
}
