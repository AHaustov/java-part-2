package de.haust.demo.service;

import de.haust.demo.dto.SearchFormDto;
import de.haust.demo.entity.Contact;
import de.haust.demo.repository.IContactRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact get(int id) {
        return contactRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact remove(int id) {
        Contact res = get(id);
        contactRepo.deleteById(id);
        return res;
    }

    public List<Contact> getAll() {
        Iterable<Contact> contacts = contactRepo.findAll();
        List<Contact> list = new ArrayList<>();
        contacts.forEach(list::add);
        return list;
    }

    public List<Contact> findByPattern(SearchFormDto searchForm) {
        String searchPattern = searchForm.getSearchPattern();
        List<Contact> results = contactRepo
                .findByFirstNameContainingOrLastNameContaining(searchPattern,searchPattern);
        return results;
    }
}
