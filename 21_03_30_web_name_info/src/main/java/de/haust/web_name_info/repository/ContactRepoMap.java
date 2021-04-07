package de.haust.web_name_info.repository;

import de.haust.web_name_info.entity.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactRepoMap implements IContactRepo {
    private final Map<Integer, Contact> contacts;

    public ContactRepoMap() {
        this.contacts = new HashMap<>();
    }

    public ContactRepoMap(Map<Integer, Contact> contacts) {
        this.contacts = new HashMap<>(contacts);
    }

    public void save(Contact contact) {
        if (contact.getId() == 0)
            contact.setId(firstFreeIndex());
        this.contacts.put(contact.getId(), contact);
    }

    public Contact remove(String id) {
        int index = Integer.parseInt(id);
        return this.contacts.remove(index);
    }

    public Contact get(String id) {
        int index = Integer.parseInt(id);
        return contacts.get(index);
    }

    public List<Contact> findAll() {
        return new ArrayList<>(contacts.values());
    }

    private int firstFreeIndex() {
        int i = 1;
        while (contacts.containsKey(i))
            i++;
        return i;
    }

}
