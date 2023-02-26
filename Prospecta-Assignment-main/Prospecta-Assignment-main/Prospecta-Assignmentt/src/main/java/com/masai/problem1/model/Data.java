package com.masai.problem1.model;

import java.util.List;

public class Data {

	private Integer count;
	
	private List<Entry> entries;
	
	
	public Data() {
		
	}


	public Data(Integer count, List<Entry> entries) {
		super();
		this.count = count;
		this.entries = entries;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public List<Entry> getEntries() {
		return entries;
	}


	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
	
	
}
