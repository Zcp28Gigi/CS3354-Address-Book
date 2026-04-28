package addressbook;

public class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Gets the name of the contact.
     * 
     * @return name of the contact
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the phone number of the contact.
     * 
     * @return phone number of the contact
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the email of the contact.
     * 
     * @return email of the contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the name of the contact.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the phone number of the contact.
     * 
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the email of the contact.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the contact.
     * 
     * @return String in the format "Name | Phone | Email"
     */
    @Override
    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}
