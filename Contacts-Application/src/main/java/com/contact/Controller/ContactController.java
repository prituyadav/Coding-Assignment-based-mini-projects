package com.contact.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.contact.Entity.Contact;
import com.contact.Services.ContactService;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String listContacts(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "contact-list";
    }
       
    
    @GetMapping("/add")
    public String showAddContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute("contact") Contact contact) {
        contactService.createContact(contact);
        return "redirect:/contacts";
    }
    
    
    @GetMapping("/add-phone-number/{id}")
    public String showAddPhoneNumberForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contactId", id);
        return "contact-add-phone-number";
    }

    // Search Contacts
    @GetMapping("/search")
    public String searchContacts(@RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                                 @RequestParam(name = "email", required = false) String email,
                                 Model model) {
        List<Contact> contacts;

        if (name != null && !name.isEmpty()) {
            contacts = contactService.searchContactsByName(name);
        } else if (phoneNumber != null && !phoneNumber.isEmpty()) {
            contacts = contactService.searchContactsByPhoneNumber(phoneNumber);
        } else if (email != null && !email.isEmpty()) {
            contacts = contactService.searchContactsByEmail(email);
        } else {
            contacts = contactService.getAllContacts();
        }

        model.addAttribute("contacts", contacts);
        return "contact-list";
    }
    
    
    

    @GetMapping("/details/{id}")
    public String showContactDetails(@PathVariable("id") Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "contact-details";
    }

    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String showEditContactForm(@PathVariable("id") Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("/edit/{id}")
    public String updateContact(@PathVariable("id") Long id, @ModelAttribute("contact") Contact updatedContact) {
        contactService.updateContact(id, updatedContact);
        return "redirect:/contacts";
    }

    @PostMapping("/add-phone-number/{id}")
    public String addPhoneNumber(@PathVariable("id") Long id, @RequestParam("phoneNumber") String phoneNumber) {
        contactService.addPhoneNumber(id, phoneNumber);
        return "redirect:/contacts/details/" + id;
    }

    @GetMapping("/delete-phone-number/{id}/{phoneNumber}")
    public String deletePhoneNumber(@PathVariable("id") Long id, @PathVariable("phoneNumber") String phoneNumber) {
        contactService.deletePhoneNumber(id, phoneNumber);
        return "redirect:/contacts/details/" + id;
    }
}

