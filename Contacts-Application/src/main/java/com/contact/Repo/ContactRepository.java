package com.contact.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.Entity.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstNameContainingIgnoreCase(String name);
    
    List<Contact> findByLastNameContainingIgnoreCase(String name);
    
    List<Contact> findByEmailContainingIgnoreCase(String email);
    
    List<Contact> findByPhoneNumbersContaining(String phoneNumber);

}
