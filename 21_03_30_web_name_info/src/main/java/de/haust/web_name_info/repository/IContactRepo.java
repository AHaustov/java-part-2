package de.haust.web_name_info.repository;

import de.haust.web_name_info.entity.Contact;

import java.util.List;

public interface IContactRepo {
    Contact get(String id);

    void save(Contact contact);

    Contact remove(String id);

    List<Contact> findAll();
}
