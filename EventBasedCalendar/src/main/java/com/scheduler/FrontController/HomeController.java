package com.scheduler.FrontController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daos.ClientDao;
import com.daos.EventDao;
import com.entities.Client;
import com.entities.Events;



@Controller
public class HomeController {
	@Autowired
	ClientDao clientDao;
	
	@Autowired
	EventDao eventDao;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String Print(ModelMap map){
		System.out.println("I m in Preform");
		Client cObj=new Client();
		map.addAttribute("cObj",cObj);
		return "HomePage";
	}
	
	@RequestMapping(value="/submitOnDb" , method=RequestMethod.POST)
	public String submitClient(@ModelAttribute ("cObj")Client cObj,ModelMap map){
	
		
		clientDao.addClient(cObj);
		
		String eventData=cObj.getEventData();
		
		
		
		String events[]=eventData.split("\n");
		for(String event:events){
			String events2[]=event.split(",");
			Events eObj=new Events();
			eObj.setCli(cObj);
			eObj.setEventType(events2[0]);
			eObj.setStartTimeDate(events2[1]);
			eObj.setEndTimeDate(events2[2]);
			//eObj.setPlace(events2[3]);
			eventDao.addEvent(eObj);
			
		}
		
		
		
		map.addAttribute("msg","{Data Added successfully");
		
		return "HomePage";
	}
	
	@RequestMapping(value="/view" , method=RequestMethod.GET)
	public @ResponseBody List<Client> viewClient(ModelMap map){
			List<Client>  clientList=clientDao.getAllClient();
			map.addAttribute("clients",clientList);
			return clientList;
		
	}
	@RequestMapping(value="/viewClientEvent/{clientId}" , method=RequestMethod.GET)
	public ModelAndView viewClientEvent(@PathVariable int clientId,ModelMap map){
			System.out.println(clientId);
			ModelAndView mv=new ModelAndView("EventView"); 
			mv.addObject("clientId",clientId);    
			List<Events> eventList=eventDao.viewAllEventsById(clientId);
			for(Events event:eventList){
			System.out.println("Event"+event);
			}
			mv.addObject("EventsList", eventList);
			
			return mv;
		
	}
	
	
}
