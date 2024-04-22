package factory;

import strategy.Contact;

import java.util.ArrayList;
import java.util.List;

public class NameFilter implements Filter {
    private String name;

    public NameFilter(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    @Override
    public List<Contact> apply(List<Contact> contacts) {
        List<Contact> filteredContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (name.isEmpty() || contact.getName().contains(name)) {
                filteredContacts.add(contact);
            }
        }
        return filteredContacts;
    }
}
