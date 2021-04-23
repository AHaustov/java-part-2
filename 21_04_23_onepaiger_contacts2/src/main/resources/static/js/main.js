document.addEventListener("DOMContentLoaded", function () {
    const contactTemplateDom = document.querySelector("#contact-template");
    const contactWrapperDom = document.querySelector("#contact-wrapper");
    const contactClient = new ContactClient();
    const contactFormDom = document.querySelector("#contact-form");
    const contactRenderer = new ContactRenderer(contactTemplateDom, contactWrapperDom);

    const contactService = new ContactService(contactClient, contactRenderer);
    const contactFormClickListener = new ContactFormClickListener(contactService);
    contactFormDom.addEventListener("click", contactFormClickListener);
});

const HOST = "http://localhost:8080/api/contacts";

class ContactFormClickListener {
    constructor(contactService) {
        this.contactservice = contactService;
    }

    handleEvent(event) {
        event.preventDefault();
        const button = event.target.closest("button");

        if (button) {
            this[button.dataset.action]();
        }

    }

    //ToDo implement. The method must retrieve all the inputs from the form(4.1),compose the object
    // based on the inputs.{name:"name",lastName:"lastName",...} Then call the method service.add(contact)
    add(event) {
        const contactFormDom = document.forms["contact-form"]

        const contact = {
            name: contactFormDom.name.value,
            lastName: contactFormDom.lastName.value,
            age: contactFormDom.age.value
        }
        this.contactservice.add(contact);
    }

    edit(event) {

    }

    cancel(event) {

    }

    removeContact(event) {
        const id = event.target.closest("contact-template").id;
        this.contactservice.remove(id);
    }

    editContact(event) {

    }

}

class ContactService {
    constructor(client, renderer) {
        this.client = client;
        this.renderer = renderer;

        this.loadAll();
    }

    async loadAll() {
        this.renderer.clearAll();
        const response = await this.client.getAll();
        if (response.ok) {
            const contacts = await response.json();
            this.renderer.renderContacts(contacts);
        }

    }

    async add(contact) {
        //TODO call the client to send new contact to the server and then remove all old contacts from the
        //contact wrapper in html and fetch all contacts from the server again and then render them all
        const response = await this.client.add(contact);
        if (response.ok) {
            this.loadAll();
        }
    }

    async remove(id) {
        const response = await this.client.remove(id);
        if (response.ok) {
             this.loadAll();
        }
    }
}

//to render html elements
class ContactRenderer {
    constructor(contactTemplateDom, contactWrapperDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.contactWrapperDom = contactWrapperDom;
    }

    renderContact(contact) {
        const contactDom = this.contactTemplateDom.cloneNode(true);
        contactDom.id = "";
        contactDom.querySelector('span[data-id="name"]').innerHTML = contact.name;
        contactDom.querySelector('span[data-id="lastName"]').innerHTML = contact.lastName;
        contactDom.classList.remove("hide");


        this.contactWrapperDom.append(contactDom);
    }

    renderContacts(contacts) {
        for (let contact of contacts) {
            this.renderContact(contact);
        }
    }

    //ToDo the method must clear the contactTemplateDOM(remove all contacts)
    clearAll() {
        const contacts = this.contactWrapperDom.querySelectorAll("#contact-template");
        for (let contact of contacts) {
            contact.remove();
        }
    }
}

//only for requesting the server
class ContactClient {


    getAll() {
        return fetch(HOST);
    }

    get(id) {
    }

    edit(contact) {
    }

    add(contact) {
        return fetch(HOST, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
    }

    remove(id) {
        return fetch(HOST + `/${id}`, {
            method: 'DELETE',
        });
    }
}