document.addEventListener("DOMContentLoaded", function () {
    const contactTemplateDom = document.querySelector("#contact-template");
    const contactWrapperDom = document.querySelector("#contact-wrapper");
    const contactClient = new ContactClient();
    const contactFormDom = document.querySelector("#contact-form");
    const contactRenderer = new ContactRenderer(contactTemplateDom, contactWrapperDom, contactFormDom);
    const contactSearchDom = document.querySelector("#searchForm");
    const contactService = new ContactService(contactClient, contactRenderer);
    const contactWrapperListener = new ContactWrapperListener(contactService);
    const contactFormClickListener = new ContactFormClickListener(contactService);

    contactFormDom.addEventListener("click", contactFormClickListener);
    contactWrapperDom.addEventListener("click", contactWrapperListener);
    contactSearchDom.addEventListener("click", contactFormClickListener);
});

const HOST = "http://localhost:8080/api/contacts";


class ContactWrapperListener {
    constructor(contactService) {
        this.contactservice = contactService;
    }

    handleEvent(event) {
        event.preventDefault();
        const aDOM = event.target.closest("a");

        if (aDOM) {
            this[aDOM.dataset.action](event);
        }
    }

    toggleDetails(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactservice.toggle(contactDom);
    }

    removeContact(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactservice.remove(contactDom.contact);
    }

    editContact(event) {
        const contactDom = event.target.closest(".contact-item");
        this.contactservice.startEdit(contactDom.contact);
    }
}


class ContactFormClickListener {
    constructor(contactService) {
        this.contactservice = contactService;
    }

    handleEvent(event) {
        event.preventDefault();
        const button = event.target.closest("button");

        if (button) {
            this[button.dataset.action](event);
        }

    }


    add(event) {
        const contactFormDom = event.currentTarget;//document.forms["contact-form"]

        const contact = {
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value
        }
        this.contactservice.add(contact);
    }

    edit(event) {
        const contactFormDom = event.currentTarget;//document.forms["contact-form"]

        const contact = {
            id: contactFormDom.elements.id.value,
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value
        }
        this.contactservice.completeEdit(contact);
    }

    cancel(event) {
        this.contactservice.cancelEdit();
    }

    search(event) {
        console.log("search started")
        const contactFormDom = event.currentTarget;
        const searchPattern = contactFormDom.elements.searchPattern;
        this.contactservice.loadSearchResults(searchPattern);
    }

    refresh(event) {
        this.contactservice.refresh(event);
    }

}

class ContactService {
    constructor(client, renderer) {
        this.client = client;
        this.renderer = renderer;

        this.loadAll();
    }

    async loadAll() {

        const response = await this.client.getAll();
        if (response.ok) {
            const contacts = await response.json();
            this.renderer.renderContacts(contacts);
        }

    }

    async loadSearchResults(searchPattern) {

        const response = await this.client.getAll();
        if (response.ok) {

            this.renderer.clearAll();
            const contacts = await response.json();
            for (let contact of contacts) {
                if (contact.name.includes(searchPattern.value)
                    || contact.lastName.includes(searchPattern.value)) {
                    this.renderer.renderContact(contact);
                }
            }
        }
        this.renderer.clearSearch();
    }

    async add(contact) {
        const response = await this.client.add(contact);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.clearForm();
            this.loadAll();
        }
    }

    toggle(contactDom) {
        const detailsDom = contactDom.querySelector("#user-details")
        detailsDom.classList.contains("hide")
            ? detailsDom.classList.remove("hide") : detailsDom.classList.add("hide");
    }

    async remove(contact) {
        const response = await this.client.remove(contact.id);
        if (response.ok) {
            this.renderer.clearAll();
            this.loadAll();
        }
    }

    startEdit(contact) {
        this.renderer.toEditForm(contact);
    }

    async completeEdit(contact) {
        const response = await this.client.edit(contact);
        if (response.ok) {
            this.renderer.clearAll();
            this.renderer.toAddForm();
            this.loadAll();
        }
    }

    cancelEdit() {
        this.renderer.toAddForm();
    }

    refresh(event) {
        this.renderer.clearAll();
        this.renderer.clearSearch();
        this.renderer.clearForm();
        this.loadAll();
    }
}

//to render html elements
class ContactRenderer {
    constructor(contactTemplateDom, contactWrapperDom, contactFormDom) {
        this.contactTemplateDom = contactTemplateDom;
        this.contactWrapperDom = contactWrapperDom;
        this.contactFormDom = contactFormDom;
        this.addButton = this.contactFormDom.querySelector("button[data-action='add']")
        this.editButton = this.contactFormDom.querySelector("button[data-action='edit']")
        this.cancelButton = this.contactFormDom.querySelector("button[data-action='cancel']")
    }


    renderContact(contact) {
        const contactDom = this.contactTemplateDom.cloneNode(true);
        contactDom.contact = contact;
        contactDom.removeAttribute("id");
        contactDom.querySelector('span[data-id="name"]').innerHTML = contact.name;
        contactDom.querySelector('span[data-id="lastName"]').innerHTML = contact.lastName;
        contactDom.classList.remove("hide");
        const detailsDom = contactDom.querySelector("#user-details");
        detailsDom.querySelector(".name").innerHTML = contact.name;
        detailsDom.querySelector(".lastName").innerHTML = contact.lastName;
        detailsDom.querySelector(".age").innerHTML = contact.age;

        this.contactWrapperDom.append(contactDom);
    }

    renderContacts(contacts) {
        for (let contact of contacts) {
            this.renderContact(contact);
        }
    }


    clearAll() {

        this.contactWrapperDom.innerHTML = "";
    }

    clearForm() {
        this.contactFormDom.elements.id.value = "";
        this.contactFormDom.elements.name.value = "";
        this.contactFormDom.elements.lastName.value = "";
        this.contactFormDom.elements.age.value = "";
    }

    toEditForm(contact) {
        this.clearForm();
        this.addButton.classList.add("hide");
        this.editButton.classList.remove("hide");
        this.cancelButton.classList.remove("hide");

        this.contactFormDom.elements.id.value = contact.id;
        this.contactFormDom.elements.name.value = contact.name;
        this.contactFormDom.elements.lastName.value = contact.lastName;
        this.contactFormDom.elements.age.value = contact.age;
    }

    toAddForm() {
        this.clearForm();
        this.addButton.classList.remove("hide");
        this.editButton.classList.add("hide");
        this.cancelButton.classList.add("hide");

    }

    clearSearch() {
        searchForm.elements.searchPattern.value = "";
    }
}

//only for requesting the server
class ContactClient {


    getAll() {
        return fetch(HOST);
    }


    get(id) {
        return fetch(HOST + `/${id}`);
    }

    edit(contact) {
        return fetch(HOST, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        });
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
            method: 'DELETE'
        });
    }


}