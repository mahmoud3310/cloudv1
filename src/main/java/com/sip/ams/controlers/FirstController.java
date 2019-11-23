package com.sip.ams.controlers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entitis.Animal;

@Controller
public class FirstController {
	
	@GetMapping("/home")
	//@ResponseBody
	public String home () 
	{
		//return "<h1> Hello spring boot home</h1>"  ;
		return "/First/home";
	}
	
	
	
	

	@GetMapping("/accueil")
	//@ResponseBody
	public String accueil (@RequestParam (required=false , defaultValue ="Spring Boot"   ) String framework
			, @RequestParam (required=false , defaultValue ="1"  ) int version  
			,  ModelMap monObj  ) 
	{
		String ecole = "POLYTECH" ;
		String formation = "spring boot et angular" ;
		String ch = "vous avez choisie :"+framework ;
		int v = version ;
		ArrayList<String> names = new ArrayList<String>();
		names.add("Mahmoud");
		names.add("mohamed");
		names.add("samah");
		monObj.put("version",v);
		monObj.put("msg",ch);
		monObj.put("ec",ecole);
		monObj.put("forma",formation);
		monObj.put("names",names);
		
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal ("lyon",3));
		animals.add(new Animal ("mm",5));
		animals.add(new Animal ("cc",1));
		monObj.put("anim",animals);
		
		//return "<h1> Hello spring boot home</h1>"  ;
		return "/First/accueil";
	}
	
	
	
	
	
	
	
	
	

}
