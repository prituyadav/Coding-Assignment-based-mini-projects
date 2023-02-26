package com.masai.problem1.service;

import java.util.List;

import com.masai.problem1.exception.EntryException;
import com.masai.problem1.model.Entry;
import com.masai.problem1.model.EntryDto;

public interface EntryService {

	public List<EntryDto> getTitlesAndDesctriptions(String category) throws EntryException;
	
	public Entry saveEntry(Entry entry);
	
	
	
}
