package com.pharma.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.Entity.Employee;

@Repository
public interface Repo extends JpaRepository<Employee, Integer>{

}
