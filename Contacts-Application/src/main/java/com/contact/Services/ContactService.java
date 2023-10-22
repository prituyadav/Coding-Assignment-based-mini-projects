package com.contact.Services;

import java.util.List;

import com.contact.Entity.Contact;

public interface ContactService {

    Contact createContact(Contact contact);

    Contact getContactById(Long id);

    List<Contact> getAllContacts();

    List<Contact> searchContactsByName(String name);

    List<Contact> searchContactsByPhoneNumber(String phoneNumber);

    List<Contact> searchContactsByEmail(String email);

    void updateContact(Long id, Contact updatedContact);

    void deleteContact(Long id);

    void addPhoneNumber(Long id, String phoneNumber);

    void deletePhoneNumber(Long id, String phoneNumber);
}
