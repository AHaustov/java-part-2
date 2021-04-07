package de.haust.web_name_info.controller;

import de.haust.web_name_info.entity.Contact;
import de.haust.web_name_info.service.ContactService;
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
    public String contacts() {
        return "contacts";
    }

    @ModelAttribute("contacts")
    public List<Contact> contactList() {
        return contactService.getAll();
    }

    @GetMapping("/add-contact")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable String id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable String id, Model model) {
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
    public String deleteContact(@PathVariable String id) {
        contactService.remove(id);
        return "redirect:/contacts";
    }


}
