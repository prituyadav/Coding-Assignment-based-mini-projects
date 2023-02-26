package com.masai.problem1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.problem1.exception.EntryException;
import com.masai.problem1.model.Data;
import com.masai.problem1.model.Entry;
import com.masai.problem1.model.EntryDto;
import com.masai.problem1.repository.EntryRepo;

@Service
public class EntryServiceImple implements EntryService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EntryRepo repo;

	// this is answer of 1 part of 1 question.
	
	
	@Override
	public List<EntryDto> getTitlesAndDesctriptions(String category) throws EntryException {
		
		// here I am using restTemplate because I need all  the entries in my Java application 
		// for extracting title and description from entries.
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		// As mentioned in Documentation For categories like "Science & Math" correct query would be category=science
		// so I am spliting by space and generating the String arrray and taking the first indexed, 
		String[] strArr = category.split(" ");
		String myCategory = strArr[0];
		
		// here I am using lambda expression for filtering and maping  
		List<EntryDto> list  = data.getEntries()
								   .stream()
								   .filter(e -> e.getCategory().contains(myCategory))
								   .map(e -> new EntryDto(e.getApi(),e.getDescription()))
								   .collect(Collectors.toList());
		
		return list;
		
	}

	
	// this is answer of 2 part of 1 question.
	@Override
	public Entry saveEntry(Entry entry) {
	
		// here I am using restTemplate because I need all  the entries in my Java application 
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		// getting all the entries
		List<Entry> entries = data.getEntries();
		
		
		entries.add(entry);
		
		// here I am using my local database for storing the entry because we do not have the access of the database that is given in
		// the assignment
		for(int i=0;i<entries.size();i++) {
			
			repo.save(entries.get(i));
			
		}
		
		return entry;
		
	}
	
//	this is answer of 3 part of 1 question.
	
	// ) Question: what are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?

//	Ans: 1) I will use the spring security(Authentication , Authorization) for security purpose so that only authenticated
//			person can consume my api.
//			
//		 2) I will handle all the exceptions so that the flow of our application will remain the smooth.
//		 
//		 3) I will use the data validation part so that I can ensure that particular field will can contain
//		 only specifics values. ex: email field must contains @gmail.com.
//		 
//		 4) I will use comments so that others developers can also know that the functionalities of API's.
//	
	
	

}
