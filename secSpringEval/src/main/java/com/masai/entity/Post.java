package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Post {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
	
	@NotEmpty
	@Min(value = 2, message = "want more than 2 char")
	private String title;
	
	@NotEmpty
	@Min(value = 10, message = "want more than 2 char")
	private String alldefine;
	

	private Comment comment;@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> seeds = new ArrayList<>(); 
	
}
