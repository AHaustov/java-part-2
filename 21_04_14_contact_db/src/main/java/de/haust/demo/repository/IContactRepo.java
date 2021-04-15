package de.haust.demo.repository;

import de.haust.demo.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IContactRepo extends CrudRepository<Contact, Integer> {

    List<Contact> findByFirstNameContainingOrLastNameContaining(String firstName,String lastName);
}
