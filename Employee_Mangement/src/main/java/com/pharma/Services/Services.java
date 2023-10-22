package com.pharma.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.Entity.Employee;
import com.pharma.repo.Repo;


@Service
public class Services {
	
	@Autowired
	 Repo repository;
	
	public Employee createE(Employee em) {
	      Employee emp=repository.save(em);
	       return emp;
	}
	
	public String removed(Integer id) {
		repository.deleteById(id);
		return "deleted..";
	}
	
	public Employee update(Employee em) {
		Optional<Employee> emp= repository.findById(em.getId());
		
		Employee empl=emp.get();
		empl.setEmpName(em.getEmpName());
		empl.setAddress(em.getAddress());
		empl.setDesignation(em.getDesignation());
		empl.setSalary(em.getSalary());
		
		
		return empl;
	}
	public Employee get(Integer id) {
		Optional<Employee> emp=repository.findById(id);
		Employee em=emp.get();
		
		return em;
	}
	

}
