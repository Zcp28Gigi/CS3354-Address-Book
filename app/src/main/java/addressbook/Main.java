package addressbook;

public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        book.addContact(new Contact("John", "123456", "john@email.com"));
        book.addContact(new Contact("Alice", "999", "alice@email.com"));

        System.out.println(book.findByName("Alice"));

        book.deleteByName("John");

        book.getContacts().forEach(System.out::println);
    }


}
