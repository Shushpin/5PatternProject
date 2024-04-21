package observer;

import singleton.ContactBook;
import strategy.Contact;

import java.util.List;

public class ContactListView implements ContactBookObserver {
    private ContactBook contactBook;

    public ContactListView(ContactBook contactBook) {
        this.contactBook = contactBook;
        contactBook.addObserver(this);
    }

    @Override
    public void update() {
        displayContacts(contactBook.getContacts());
    }

    private void displayContacts(List<Contact> contacts) {
        System.out.println("Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + ": " + contact.getPhoneNumber());
        }
        System.out.println();
    }
}
