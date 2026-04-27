package addressbook;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    // Add
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Delete
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    // Update
    public void updateContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    // Get all
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
