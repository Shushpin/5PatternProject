package decorator;

import singleton.ContactBook;
import observer.ContactBookObserver;

public class ContactBookWithLoggingDecorator extends ContactBook {
    private ContactBook contactBook;

    public ContactBookWithLoggingDecorator(ContactBook contactBook) {
        this.contactBook = contactBook;
    }

    @Override
    public void notifyObservers() {
        contactBook.notifyObservers();
    }

    @Override
    public void addContact(strategy.Contact contact) {
        System.out.println("Adding contact: " + contact.getName());
        contactBook.addContact(contact);
    }
}
