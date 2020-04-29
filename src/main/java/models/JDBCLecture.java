package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JDBCLecture {

    public static void main(String[] args) throws SQLException {

        //Instantiate a new models.Config object
        Config config = new Config();

        //Set up out database driver, and make a connection
        DriverManager.registerDriver(new Driver());

        //Get a connect object
        Connection conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        ); // we now have a connection to our MySql DB

        //create statement object
        Statement stat = conn.createStatement();


        //execute a query
        // create a query string to get everything in the contacts table
        String contactsQuery = "SELECT * FROM contacts_db.contacts";

        ResultSet rs = stat.executeQuery(contactsQuery);

        //display whats actually in the result set
        while(rs.next()){
            System.out.println(rs.getString("first_name") + " " +rs.getString("last_name") + " " + rs.getString("phone_number"));
        }

        //if we want to add a row to our database we will
            //1. create a contact object
            //2. create an sql qyert to insert that contact object into our data base
            //3. to add to our DAO -> instantiate ContactsDAO and use the saveContact() method
        ContactListDAO clDao = new ContactListDAO();
        Contact james = new Contact("james", "spicer", "2054545440");

        long newContactId = clDao.saveContact(james);
        Contact newlyCreatedContact = clDao.getContactById(newContactId);

        //INSERT INTO contacts ('first_name', 'last_name', 'phone_number') VALUES ('james', 'spicer', '2054545440');




        String addContactQuery = String.format("UPDATE contacts SET first_name = '%s', last_name = '%s', phone_number = '%s', WHERE id = 'id'",
                newlyCreatedContact.getFirstName(),
                newlyCreatedContact.getLastName(),
                newlyCreatedContact.getPhoneNumber()
                );

        int numRows = stat.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);

        long insertedRowId = 0;

        ResultSet theKeys = stat.getGeneratedKeys();


        stat.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);
        if(theKeys.next()){

        }

    }
}
