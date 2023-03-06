package com.masai.problem1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.problem1.exception.EntryException;
import com.masai.problem1.model.Entry;
import com.masai.problem1.model.EntryDto;
import com.masai.problem1.service.EntryService;

@RestController
public class MyController {

	@Autowired
	private EntryService service;
	
	@GetMapping("checking")
	public String checking() {
		return "working fine...";
	}
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDto>> getTitlesAndDescriptionsHandler(@PathVariable("category") String category) throws EntryException{
		
		
		List<EntryDto> entryDtos = service.getTitlesAndDesctriptions(category);
		
		
		return new ResponseEntity<List<EntryDto>>(entryDtos,HttpStatus.OK);
	}
	
	
	@PostMapping("/entries")
	public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry) {
		
		Entry savedObj = service.saveEntry(entry);
		
		return new ResponseEntity<Entry>(savedObj,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
}
