package models;

import java.util.ArrayList;
import java.util.List;

public class ContactListDAO implements Contacts{

    private List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> getContacts(){
        return contacts;
    }

    public long saveContact(Contact contact){
        if(contact.getId() == 0){
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        } else {
            // we already have the correct ID coming from the MySQL table
            contacts.set((int) contact.getId(), contact);
        }
        return contact.getId();
    }

    public void deleteContactById(long id){
        contacts.remove((int) id);
    }

    @Override
    public Contact getContactById(long id){
        return contacts.get((int) id - 1);
    }

    public static void main(String[] args) {

    }


}
