package com.mdo.services;

import java.util.List;

import com.mdo.exception.CategoryNotFoundException;
import com.mdo.exception.InvalidApiException;
import com.mdo.models.ListOfTitleAndDescription;
import com.mdo.models.SigleEntry;

public interface MainServices {
	public List<SigleEntry> getAllEntries() throws InvalidApiException;

	String getHealth();

	String saveEntry(SigleEntry entry);

	List<ListOfTitleAndDescription> getTitleAnddecByCategory(String category) throws CategoryNotFoundException;
}
