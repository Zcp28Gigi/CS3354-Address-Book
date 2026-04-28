package addressbook;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    /**
     * Add a new contact to the address book.
     * 
     * @param contact
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /**
     * Delete a contact by its index in the list.
     * 
     * @param index
     */
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    /**
     * Update a contact by its index in the list.
     * 
     * @param index
     * @param newContact
     */
    public void updateContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
        }
    }

    /**
     * Get the list of all contacts.
     * 
     * @return ArrayList of contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * Find a contact by their name.
     * 
     * @param name
     * @return Contact if found, null otherwise
     */
    public Contact findByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Delete a contact by their name.
     * 
     * @param name
     */
    public void deleteByName(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }
}
