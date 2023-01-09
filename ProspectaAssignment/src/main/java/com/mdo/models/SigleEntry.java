package com.mdo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigleEntry {
   
	
	  @JsonProperty("API")
		private String title;
		
		@JsonProperty("Description")
		private String description;
		
		@JsonProperty("Auth")
		private String auth;
		
		@JsonProperty("Https")
		private boolean hTTPS;
		
		@JsonProperty("Cors")
		private String cors;
		
		@JsonProperty("Category")
		private String category;
	
}
