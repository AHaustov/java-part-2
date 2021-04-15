package de.haust.demo.controller;

import de.haust.demo.dto.SearchFormDto;
import de.haust.demo.entity.Contact;
import de.haust.demo.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping({"/", "/contacts"})
    public String contacts(Model model) {
        model.addAttribute("contacts", contactService.getAll());
        model.addAttribute("searchForm",new SearchFormDto());
        return "contacts";
    }

    @GetMapping("/add-contact")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "user-details";
    }

    @RequestMapping(value = "/save-contact", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        contactService.remove(id);
        return "redirect:/contacts";
    }

    @PostMapping("/contacts/search")
    public String searchContacts(@ModelAttribute SearchFormDto searchForm, Model model) {
        List<Contact> results = contactService.findByPattern(searchForm);
        model.addAttribute("contacts", results);
        model.addAttribute("searchForm",new SearchFormDto());
        return "contacts";
    }
}
