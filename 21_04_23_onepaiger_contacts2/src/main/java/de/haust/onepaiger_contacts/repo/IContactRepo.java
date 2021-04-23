package de.haust.onepaiger_contacts.repo;

import de.haust.onepaiger_contacts.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface IContactRepo extends CrudRepository<Contact, Integer> {
    Collection<Contact> findAllByName(String name);

    Collection<Contact> findAllByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String partialName, String partialLastName);

    @Query("select c from Contact c where UPPER(c.name) like concat('%',UPPER(:pattern),'%') or UPPER(c.lastName) like concat('%',UPPER(:pattern),'%')")
    Collection<Contact> findAllContainingPattern(@Param("pattern") String pattern);

//    @Query("select c from Contact c where UPPER(c.name) like concat('%',UPPER(?1),'%') or UPPER(c.lastName) like concat('%',UPPER(?1),'%')")
//    Collection<Contact> findAllContainingPattern(String pattern);
}
