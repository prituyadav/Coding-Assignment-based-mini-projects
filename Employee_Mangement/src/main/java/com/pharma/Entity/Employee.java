package com.pharma.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
    
    private String empName;
    
    private String designation;
    private Integer salary;
    private String address;
    
	
	
}
