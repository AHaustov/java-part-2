package de.haust.web_name_info.service;

import de.haust.web_name_info.entity.Contact;
import de.haust.web_name_info.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    IContactRepo contacts;

    public ContactService(IContactRepo contactRepo) {
        this.contacts = contactRepo;
    }

    public Contact get(String id) {
        return contacts.get(id);
    }

    public void save(Contact contact) {
        contacts.save(contact);
    }

    public Contact remove(String id) {
        return contacts.remove(id);
    }

    public List<Contact> getAll() {
        return contacts.findAll();
    }
}
