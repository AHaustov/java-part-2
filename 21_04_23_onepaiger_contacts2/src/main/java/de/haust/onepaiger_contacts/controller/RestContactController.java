package de.haust.onepaiger_contacts.controller;

import de.haust.onepaiger_contacts.dto.ContactDto;
import de.haust.onepaiger_contacts.entity.Contact;
import de.haust.onepaiger_contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/contacts")
@RestController
public class RestContactController {

    private final ContactService contactService;

    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDto> getAll() {
        // returns data in the following format: [{"name": "Vasya", ...}, {...}, ...]
        List<Contact> contacts = contactService.getAll();
        return contacts.stream()
                .map(contactService::toContactDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ContactDto get(@PathVariable int id) {
        Contact contact = contactService.get(id);

        return contactService.toContactDto(contact);
    }

    @PostMapping
    public ContactDto create(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.name);
        contact.setLastName(contactDto.lastName);
        contact.setAge(contactDto.age);

        contactService.save(contact);
        // after saving the contact has got its id
        contactDto.id = contact.getId();
        return contactDto;
    }

    @PutMapping
    public void edit(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.id);
        contact.setName(contactDto.name);
        contact.setLastName(contactDto.lastName);
        contact.setAge(contactDto.age);

        contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        contactService.remove(id);
    }
}
