package singleton;

import observer.ContactListView;
import strategy.Contact;

import java.util.ArrayList;
import java.util.List;

public abstract class ContactBook {
    private static ContactBook instance;
    private List<Contact> contacts;

    protected ContactBook() {
        contacts = new ArrayList<>();
    }

    public static synchronized ContactBook getInstance() {
        if (instance == null) {
            instance = new ContactBook() {
                @Override
                public void addContact(Contact contact) {
                    // Пусте тіло, оскільки цей метод перевизначається в дочірніх класах
                }

                @Override
                public void notifyObservers() {

                }
            };
        }
        return instance;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyObservers();
    }

    public abstract void notifyObservers();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addObserver(ContactListView contactListView) {
        // Метод додавання спостерігача
    }
}
