package de.haust.web_name_info.dto;

import java.util.List;

public class ContactCreationDto {
    private List<Contact> contacts;

    public ContactCreationDto() {
    }

    public ContactCreationDto(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
