package de.haust.web_name_info.repository;

import de.haust.web_name_info.dto.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContactCreationDto {
    private final Map<Integer, Contact> contacts;

    public ContactCreationDto() {
        this.contacts = new HashMap<>();
    }

    public ContactCreationDto(Map<Integer, Contact> contacts) {
        this.contacts = new HashMap<>(contacts);
    }

    public void addContact(Contact contact) {
        if (contact.getId() == 0)
            contact.setId(firstFreeIndex());
        this.contacts.put(contact.getId(), contact);
    }

    public void removeContact(String id) {
        int index = Integer.parseInt(id);
        this.contacts.remove(index);
    }

    public Contact getContact(String id) {
        int index = Integer.parseInt(id);
        return contacts.get(index);
    }

    public List<Contact> getContactList() {
        return new ArrayList<>(contacts.values());
    }

    private int firstFreeIndex() {
        int i = 1;
        while (contacts.containsKey(i))
            i++;
        return i;
    }

}
