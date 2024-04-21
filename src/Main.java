import strategy.Contact;
import singleton.ContactBook;
import observer.ContactListView;
import decorator.ContactBookWithLoggingDecorator;
import factory.NameFilter;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = ContactBook.getInstance();
        ContactListView contactListView = new ContactListView(contactBook);
        ContactBookWithLoggingDecorator decoratedContactBook = new ContactBookWithLoggingDecorator(contactBook);

        decoratedContactBook.addContact(new Contact("John", "1234567890"));
        decoratedContactBook.addContact(new Contact("Smith", "0987654321"));
        contactBook.addContact(new Contact("Bob Johnson", "1112223333"));
        contactBook.addContact(new Contact("Alice Johnson", "4445556666"));


        // Використання фільтра
        List<Contact> filteredContacts = new NameFilter("Alice").apply(contactBook.getContacts());
        System.out.println("Filtered Contacts:");
        for (Contact contact : filteredContacts) {
            System.out.println(contact.getName() + ": " + contact.getPhoneNumber());
        }
    }
}
