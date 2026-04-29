package addressbook;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class AddressBookGUI {
    private AddressBook addressBook;
    private DefaultListModel<String> listModel;
    private JList<String> contactList;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    public AddressBookGUI() {
        try {
            addressBook = new AddressBook("contacts.txt");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
        }

        JFrame frame = new JFrame("Address Book");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        frame.add(inputPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);
        frame.add(new JScrollPane(contactList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            Contact c = new Contact(name, phone, email);
            try {
                addressBook.addContact(c);
            } catch (FileNotFoundException fileNotFound) {
                JOptionPane.showMessageDialog(frame, "Error writing to file.");
            }

            refreshList();
            clearFields();
        });

        updateButton.addActionListener(e -> {
            int index = contactList.getSelectedIndex();

            if (index != -1) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();

                Contact updatedContact = new Contact(name, phone, email);
                try {
                    addressBook.updateContact(index, updatedContact);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file.");
                }

                refreshList();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(frame, "Select a contact to update.");
            }
        });

        deleteButton.addActionListener(e -> {
            int index = contactList.getSelectedIndex();

            if (index != -1) {
                try {
                    addressBook.deleteContact(index);
                } catch (FileNotFoundException fileNotFound) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file.");
                }
                refreshList();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(frame, "Select a contact to delete.");
            }
        });

        contactList.addListSelectionListener(e -> {
            int index = contactList.getSelectedIndex();

            if (index != -1) {
                Contact c = addressBook.getContacts().get(index);
                nameField.setText(c.getName());
                phoneField.setText(c.getPhone());
                emailField.setText(c.getEmail());
            }
        });

        frame.setVisible(true);
    }

    private void refreshList() {
        listModel.clear();

        for (Contact c : addressBook.getContacts()) {
            listModel.addElement(c.toString());
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        new AddressBookGUI();
    }
}
