package de.haust.web_name_info.service;

import de.haust.web_name_info.dto.Contact;
import de.haust.web_name_info.dto.ContactCreationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    ContactCreationDto contacts;

    public ContactService(ContactCreationDto contactCreationDto) {
        this.contacts = contactCreationDto;
    }

    public Contact get(String id) {
        return contacts.getContact(id);
    }

    public void save(Contact contact) {
        contacts.addContact(contact);
    }

    public void delete(String id) {
        contacts.removeContact(id);
    }

    public List<Contact> getAll() {
        return contacts.getContactList();
    }
}
