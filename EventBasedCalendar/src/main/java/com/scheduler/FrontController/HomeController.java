package com.scheduler.FrontController;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daos.ClientDao;
import com.entities.Client;



@Controller
public class HomeController {
	@Autowired
	ClientDao clientDao;
	
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
		map.addAttribute("msg","{Data Added successfully");
		return "HomePage";
	}
	
	@RequestMapping(value="/view" , method=RequestMethod.GET)
	public @ResponseBody List<Client> viewClient(ModelMap map){
			List<Client>  clientList=clientDao.getAllClient();
			return clientList;
		
	}
	
}
