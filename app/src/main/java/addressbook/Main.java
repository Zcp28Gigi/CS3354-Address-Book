package addressbook;

public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        book.addContact(new Contact("John", "123456", "john@email.com"));

        for (Contact c : book.getContacts()) {
            System.out.println(c);
        }
    }
}
