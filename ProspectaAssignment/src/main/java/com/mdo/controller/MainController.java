package com.mdo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.cfg.ConstructorDetector.SingleArgConstructor;
import com.mdo.exception.CategoryNotFoundException;
import com.mdo.exception.InvalidApiException;
import com.mdo.models.AllEntries;
import com.mdo.models.ListOfTitleAndDescription;
import com.mdo.models.SigleEntry;
import com.mdo.services.MainServicesImpl;

@RestController
@RequestMapping("/myapi")
public class MainController {
	
	@Autowired
	private MainServicesImpl servises;
	

	@GetMapping("/welcome")
	public String greetings(){
		return "hello there! a very warm welcome!!!";
	}
	
	@GetMapping("/getAllEntries")
	public List<SigleEntry> getAllEntries() throws InvalidApiException{
		List<SigleEntry> st=servises.getAllEntries();
		return st;
	}
	
	@PostMapping("/saveEntries")
	public String saveEntries(@RequestBody SigleEntry entry) {
		String s=servises.saveEntry(entry);
		return s;
	}
	
	
	
	@GetMapping("/getHealth")
	public String getHealthHandler() throws InvalidApiException{
		String st=servises.getHealth();
		return st;
	}
	
	@GetMapping("/entries/{category}")
	public List<ListOfTitleAndDescription> getEntriesHandler(@PathVariable("category") String category) throws CategoryNotFoundException{
		
	     List<ListOfTitleAndDescription> list=servises.getTitleAnddecByCategory(category);
		return list;
		
	}
	
	
	
	

}
