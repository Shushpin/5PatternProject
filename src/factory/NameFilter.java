package factory;

import java.util.ArrayList;
import java.util.List;

import strategy.Contact;

public class NameFilter implements Filter {
    private String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public List<Contact> apply(List<Contact> contacts) {
        List<Contact> filteredContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(name)) {
                filteredContacts.add(contact);
            }
        }
        return filteredContacts;
    }
}
