package com.SchedulerBackEnd.BackEndEventCalendar;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DBConfig.DBconfig;
import com.daos.ClientDao;
import com.daos.EventDao;
import com.entities.Client;
import com.entities.Events;


public class AppTest 
{
	private static ClientDao cDao;
	private static EventDao eDao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBconfig.class);
		context.refresh();
		System.out.println("inside init...");
		cDao=context.getBean("clientDao",ClientDao.class);
		eDao=context.getBean("eventDao",EventDao.class);
		
	}
	
	
	@Test
	@Ignore
	public void addClientTest() {
		
		Client c=new Client();
		c.setClientName("Raghav");
		c.setProjectName("proj1");
		
		c.setAgenda("func1");
		
		
		
		assertTrue("not added", cDao.addClient(c));
		
	}
	
	@Test
	@Ignore
	public void viewClient() {
		Client cObj=cDao.viewClient(1);
		assertNotNull("Client not found",cObj);
	}
	
	@Test
	@Ignore
	public void delClient()
	{
		assertTrue("not found",cDao.delClient(3));
	}
	
//	@Test
//	public void viewAllClient()
//	{
//		
//		List<Client> actual;
//		actual=cDao.getAllClient();
//		
//		 assertThat(actual.size(), is(5));
//		
//	}
//	
	@Test
	@Ignore
	public void addEvent()
	{
		Events e=new Events();
		/*e.setStartTimeDate("25/12/2018 12:45");
		e.setEndTimeDate("25/12/2018 12:48");*/
		e.setEventType("Meeting");
		
		
		assertTrue("not added",eDao.addEvent(e));
	}
	
	@Test
	@Ignore
	public void ViewEvent()
	{
		
		Events e1=eDao.viewEvent(2);
		assertNotNull("not found",e1);
	}
	
//	@Test
//	public void ViewAllEventsById()
//	{
//		List<Events> actual1;
//		actual1=eDao.viewAllEventsById(1);
//		
//	}
	
	@Test
	public void addClientWithEvent()
	{
		Events e1=new Events();
		/*e1.setStartTimeDate("25/12/2018 12:45");
		e1.setEndTimeDate("25/12/2018 12:48");*/
		e1.setEventType("Meeting");
		
		
		
		
		Events e2=new Events();
	/*	e2.setStartTimeDate("29/10/2018 12:45");
		e2.setEndTimeDate("30/10/2018 12:48");
		*/e2.setEventType("Hotel");
		
		
		Set<Events> eve=new HashSet<Events>();
		eve.add(e1);
		eve.add(e2);
		
		
		Client c=new Client();
		c.setClientName("Raghav");
		c.setProjectName("proj1");
		
		c.setAgenda("func1");
		//c.setEve(eve);
		
		e1.setCli(c);
		e2.setCli(c);
		
		
		assertTrue("can't add",cDao.addClient(c));
		
	}
	
	
}














