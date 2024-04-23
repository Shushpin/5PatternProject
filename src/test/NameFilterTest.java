package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import factory.NameFilter;
import strategy.Contact;

public class NameFilterTest {

    @Test
    public void testApplyFilter() {
        // Створюємо список контактів
        List<Contact> contacts = Arrays.asList(
                new Contact("John Doe", "1234567890"),
                new Contact("Alice Smith", "0987654321"),
                new Contact("Bob Johnson", "1112223333"),
                new Contact("Alice Johnson", "4445556666")
        );

        // Створюємо об'єкт фільтра з ім'ям "Alice"
        NameFilter filter = new NameFilter("Alice");

        // Застосовуємо фільтр до списку контактів
        List<Contact> filteredContacts = filter.apply(contacts);

        // Перевіряємо, чи відфільтровані контакти містять тільки контакти з ім'ям "Alice"
        assertEquals(2, filteredContacts.size());
        assertTrue(filteredContacts.stream().allMatch(contact -> contact.getName().contains("Alice")));
    }

    @Test
    public void testApplyFilterNoMatch() {
        // Створюємо список контактів
        List<Contact> contacts = Arrays.asList(
                new Contact("John Doe", "1234567890"),
                new Contact("Bob Johnson", "1112223333")
        );

        // Створюємо об'єкт фільтра з ім'ям "Alice"
        NameFilter filter = new NameFilter("Alice");

        // Застосовуємо фільтр до списку контактів
        List<Contact> filteredContacts = filter.apply(contacts);

        // Перевіряємо, що відфільтрований список пустий, оскільки жоден контакт не має імені "Alice"
        assertTrue(filteredContacts.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApplyFilterNullName() {
        // Створюємо список контактів
        List<Contact> contacts = Arrays.asList(
                new Contact("John Doe", "1234567890"),
                new Contact("Alice Smith", "0987654321")
        );

        // Спробуємо створити фільтр з null ім'ям
        NameFilter filter = new NameFilter(null);

        // Повинен бути викинутий IllegalArgumentException
    }

    @Test
    public void testApplyFilterWithNumbers() {
        // Створюємо список контактів
        List<Contact> contacts = Arrays.asList(
                new Contact("John Doe", "1234567890"),
                new Contact("Alice Smith", "0987654321"),
                new Contact("Bob 123", "1112223333")
        );

        // Створюємо об'єкт фільтра з ім'ям, що містить числа
        NameFilter filter = new NameFilter("123");

        // Застосовуємо фільтр до списку контактів
        List<Contact> filteredContacts = filter.apply(contacts);

        // Перевіряємо, що відфільтровані контакти містять тільки контакти з ім'ям, що містить числа
        assertEquals(1, filteredContacts.size());
        assertTrue(filteredContacts.stream().allMatch(contact -> contact.getName().contains("123")));
    }



    @Test
    public void testApplyFilterMultipleMatches() {
        List<Contact> contacts = Arrays.asList(
                new Contact("John Doe", "1234567890"),
                new Contact("Alice Smith", "0987654321"),
                new Contact("Alice Johnson", "4445556666"),
                new Contact("Bob Johnson", "1112223333")
        );

        NameFilter filter = new NameFilter("Johnson");
        List<Contact> filteredContacts = filter.apply(contacts);

        assertEquals(2, filteredContacts.size());
        assertTrue(filteredContacts.stream().allMatch(contact -> contact.getName().contains("Johnson")));
    }
    @Test
    public void testApplyFilterCaseInsensitive() {}
}
