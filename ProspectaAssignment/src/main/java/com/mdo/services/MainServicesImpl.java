package com.mdo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mdo.exception.CategoryNotFoundException;
import com.mdo.exception.InvalidApiException;
import com.mdo.models.AllEntries;
import com.mdo.models.ListOfTitleAndDescription;
import com.mdo.models.SigleEntry;

@Service
public class MainServicesImpl implements MainServices{
	
	@Value("${external.api.url}")
	private String baseUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<SigleEntry> getAllEntries() throws InvalidApiException {
     AllEntries allE=restTemplate.getForObject(baseUrl+"/entries", AllEntries.class);
		
		List<SigleEntry> en=allE.getAllEntries();
		
		return en;
	}
	
	
	
	@Override
	public String saveEntry(SigleEntry entry) {
		AllEntries allE=restTemplate.getForObject(baseUrl+"/entries", AllEntries.class);
		List<SigleEntry> en=allE.getAllEntries();
		en.add(entry);
	    
//		Long c=allE.getCount()+1;
//		
//		AllEntries a=new AllEntries(c,en);
//		
//		HttpHeaders h=new HttpHeaders();
//		h.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpEntity<AllEntries> he=new HttpEntity<>(a,h);
//		
//		ResponseEntity<AllEntries> responseEntity =restTemplate.postForEntity(baseUrl+"/entries", he, AllEntries.class);
//		
//		if(responseEntity.getStatusCode()==HttpStatus.CREATED)		
//	      return "entry saved successfully..";
//		else
//			return "entry not saved";
		
		
		 return "entry saved successfully..";
		
	}

	
	@Override
	public List<ListOfTitleAndDescription> getTitleAnddecByCategory(String category) throws CategoryNotFoundException{
		
		AllEntries d= restTemplate.getForObject("https://api.publicapis.org/entries", AllEntries.class);
		
		List<SigleEntry> entries= d.getAllEntries();
	
		List<ListOfTitleAndDescription> list = new ArrayList<>();
		
		for(SigleEntry en:entries) {
			
			if(en.getCategory().equals(category))
				list.add(new ListOfTitleAndDescription(en.getTitle(), en.getDescription()));
		}
		
		return list;
		
		
	}
	
	
	@Override
	public String getHealth() {
		String h=restTemplate.getForObject(baseUrl+"/health", String.class);
		return h;
	}

	
	
	
}
