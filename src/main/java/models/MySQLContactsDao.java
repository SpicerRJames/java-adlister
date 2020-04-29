package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactsDao implements Contacts {

    private Connection conn;

    public MySQLContactsDao() throws SQLException {
        // Instantiate a Config object
        Config config = new Config();
​
        // Set up our database driver, and make a connection
        DriverManager.registerDriver(new Driver());
​
        // Get a connection object
        this.conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword() // see, no passwords in plain text!
        ); // we now have a connection to our MySQL DB
    }


    public MySQLContactsDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Contact> getContacts() /*throws SQLException*/{
        List<Contact> output = new ArrayList<>();
        String query = "SELECT * FROM contacts";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //Iterate through our result set and each contact to our 'Contact" bean
            while(rs.next()){
                output.add(
                        new Contact(
                                rs.getLong("id"), //id
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("phone_number")
                        )
                );
            }

        } catch (SQLException c) {
            c.printStackTrace();
        }
        return output; // return the List<Contact> of all the contacts we imported from MySQL DB
    }

    @Override
    public long saveContact(Contact contact) {
        //
    }

    @Override
    public void deleteContactById(long id) {

        //SQL equivelent for deleting rox by id: DELETE FRON contacts WHERE id = sentInId
        String query = String.format("DELETE FROM contacts WHERE id = %d", id);


        try{
            Statement stmt = conn.createStatement();
            boolean success = stmt.execute(query);
            if(success){
                System.out.println("Contacts have been deleted");
            }else{
                System.out.println("Contact was not deleted, check syntax");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getContactById(long id) {

        Contact returnContact = new Contact();
        String query = String.format("SELECT FROM cnotacts WHERE id = %d", id);

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery(query);

            if(rs.next()){
                returnContact.setId(id);
                returnContact.setFirstName("first_name");
                returnContact.setLastName("last_name");
                returnContact.setPhoneNumber("phone_number");
            }else{
                System.out.println("Supplied user id found no contact that matches.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return returnContact;
    }
}
