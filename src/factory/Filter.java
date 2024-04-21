package factory;

import strategy.Contact;

import java.util.List;

public interface Filter {
    List<Contact> apply(List<Contact> contacts);
}
