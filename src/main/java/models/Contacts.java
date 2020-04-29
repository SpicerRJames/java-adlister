package models;

import java.util.List;

public interface Contacts {

    //List all the contacts (List<models.Contact>)

    List<Contact> getContacts();

    //method for saving a contact
    long saveContact(Contact contact);

    //method for deleting a contact
    void deleteContactById(long id);

    //get contact by their id
    Contact getContactById(long id);

}
