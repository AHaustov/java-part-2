package de.haust.web_name_info.controller;

import de.haust.web_name_info.dto.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ContactController {

    public List<Contact> contacts = Arrays.asList(
            new Contact(0, "Vasya", "Vasin", 21),
            new Contact(1, "Petya", "Peterson", 22)
    );

    @ModelAttribute("newIndex")
    public int newIndex() {
        return contacts.size();
    }

    @GetMapping({"/", "/contacts"})
    public String contacts() {
        // model.addAttribute("contacts", contacts);
        return "contacts";
    }

   @ModelAttribute("contacts")
    public List<Contact> contactList() {
        return contacts;
    }

    @GetMapping("/add-contact")
    public String addContact(Model model) {
        /*ContactCreationDto contactForm = new ContactCreationDto();
        contactForm.addContact(new Contact());
        model.addAttribute("form", contactForm);*/
        model.addAttribute("contact",new Contact());
        return "contact-form";
    }

    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable int id,Model model) {
        model.addAttribute("contact",contacts.get(id));
        return "contact-form";
    }

    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id,Model model) {
        model.addAttribute("contact",contacts.get(id));
        return "user-details";
    }

    @PostMapping("/save-contact")
    @ResponseBody
    public String saveContact(){

        return "redirect:contacts";
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        contacts.remove(id);
        return "redirect:contacts";
    }

   /* @PostMapping("/contacts")
    @ResponseBody
    public String acceptContact(@RequestBody Contact contact, @Qualifier("list") List<Contact> list) {
        list.add(contact);
        return "You added the following contact: " + contact.getFirstName() + " " + contact.getLastName();
    }*/
}