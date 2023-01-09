package com.mdo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfTitleAndDescription {
  
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
}
