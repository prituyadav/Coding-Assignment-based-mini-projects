package com.contact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.Entity.Contact;
import com.contact.Exceptions.ContactNotFoundException;
import com.contact.Exceptions.PhoneNumberNotFoundException;
import com.contact.Repo.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        }
        throw new ContactNotFoundException("Contact with ID " + id + " not found.");
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> searchContactsByName(String name) {
        return contactRepository.findByFirstNameContainingIgnoreCase(name);
    }

    @Override
    public List<Contact> searchContactsByPhoneNumber(String phoneNumber) {
        return contactRepository.findByPhoneNumbersContaining(phoneNumber);
    }

    @Override
    public List<Contact> searchContactsByEmail(String email) {
        return contactRepository.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public void updateContact(Long id, Contact updatedContact) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact with ID " + id + " not found."));
        contact.setFirstName(updatedContact.getFirstName());
        contact.setLastName(updatedContact.getLastName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhoneNumbers(updatedContact.getPhoneNumbers());
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new ContactNotFoundException("Contact with ID " + id + " not found.");
        }
        contactRepository.deleteById(id);
    }

    @Override
    public void addPhoneNumber(Long id, String phoneNumber) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact with ID " + id + " not found."));
        contact.getPhoneNumbers().add(phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public void deletePhoneNumber(Long id, String phoneNumber) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact with ID " + id + " not found."));

        if (!contact.getPhoneNumbers().contains(phoneNumber)) {
            throw new PhoneNumberNotFoundException("Phone number not found for the contact with ID " + id);
        }

        contact.getPhoneNumbers().remove(phoneNumber);
        contactRepository.save(contact);
    }
}

