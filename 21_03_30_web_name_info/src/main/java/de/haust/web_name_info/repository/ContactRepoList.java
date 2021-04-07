package de.haust.web_name_info.repository;

import de.haust.web_name_info.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepoList implements IContactRepo {

    private final List<Contact> contacts;
    private int lastIndex;

    public ContactRepoList() {
        this.contacts = new ArrayList<>();
    }

    public ContactRepoList(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Contact get(String id) {
        int index = Integer.parseInt(id);
        Contact contact = contacts.stream()
                .filter(con -> con.getId() == index)
                .findFirst()
                .orElseThrow();
        return contact;
    }

    @Override
    public void save(Contact contact) {
        if (contact.getId() <= 0) {
            contact.setId(++lastIndex);
            contacts.add(contact);
        } else {
            Contact cont = contacts.stream()
                    .filter(con -> con.getId() == contact.getId())
                    .findFirst()
                    .orElseThrow();
            cont.setFirstName(contact.getFirstName());
            cont.setLastName(cont.getLastName());
            cont.setAge(contact.getAge());
        }
    }

    @Override
    public Contact remove(String id) {
        int index = Integer.parseInt(id);
        Contact contact = contacts.stream()
                .filter(con -> con.getId() == index)
                .findFirst()
                .orElseThrow();
        contacts.remove(contact);
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }
}
