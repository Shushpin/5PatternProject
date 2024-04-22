package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import strategy.Contact;

public class ContactTest {

    @Test
    public void testContactCreationWithValidData() {
        Contact contact = new Contact("John Doe", "1234567890");
        assertEquals("John Doe", contact.getName());
        assertEquals("1234567890", contact.getPhoneNumber());
    }


    @Test
    public void testContactInequality() {
        Contact contact1 = new Contact("John Doe", "1234567890");
        Contact contact2 = new Contact("Alice Smith", "0987654321");
        assertFalse(contact1.toString().equals(contact2.toString()));
    }
}
