package addressbook;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class AddressBook {
    private ArrayList<Contact> contacts;
    private String fileName;

    public AddressBook(String fileName) throws FileNotFoundException {
        contacts = new ArrayList<>();
        this.fileName = fileName;
        // Load contacts from file if it exists
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    contacts.add(new Contact(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Error reading from file: " + fileName);
        }
    }

    /**
     * Add a new contact to the address book and writes it to the file.
     * 
     * @param contact
     */
    public void addContact(Contact contact) throws FileNotFoundException {
        contacts.add(contact);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            pw.println(contact.toString());
            pw.close();
        } catch (Exception fileNotFound) {
            throw new FileNotFoundException("Unable to write to file: " + fileName);
        }
    }

    /**
     * Delete a contact by its index in the list and removes it from the file.
     * 
     * @param index
     */
    public void deleteContact(int index) throws FileNotFoundException {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(fileName));
                for (Contact c : contacts) {
                    pw.println(c.toString());
                }
                pw.close();
            } catch (Exception fileNotFound) {
                throw new FileNotFoundException("Unable to write to file: " + fileName);
            }
        }
    }

    /**
     * Update a contact by its index in the list and updates it in the file.
     * 
     * @param index
     * @param newContact
     */
    public void updateContact(int index, Contact newContact) throws FileNotFoundException {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(fileName));
                for (Contact c : contacts) {
                    pw.println(c.toString());
                }
                pw.close();
            } catch (Exception fileNotFound) {
                throw new FileNotFoundException("Unable to write to file: " + fileName);
            }
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
     * Delete a contact by their name and deletes it from the file.
     * 
     * @param name
     */
    public void deleteByName(String name) throws FileNotFoundException {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (Contact c : contacts) {
                pw.println(c.toString());
            }
            pw.close();
        } catch (Exception fileNotFound) {
            throw new FileNotFoundException("Unable to write to file: " + fileName);
        }
    }
}
