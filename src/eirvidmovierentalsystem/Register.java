package eirvidmovierentalsystem;

import SQL.SQLConnection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends Menu {

    private String email;
    private String username;
    private String password;

   
    public void Register() {

        System.out.println("---------- REGISTRATION PAGE ----------");

        System.out.println("Please enter your email:");
        email = s.nextLine();

        System.out.println("Please enter your username:");
        username = s.nextLine();

        System.out.println("Please enter your password:");
        password = s.nextLine();

        try {

            //loads the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //retrieves and stores the query
            String insert = "INSERT INTO customers (email, username, password) VALUES (?, ?, ?)";

            //gets a statement from the connection
            conn.prepareStatement(insert);

            //passses the parameters
            conn.getPst().setString(1, email);
            conn.getPst().setString(2, username);
            conn.getPst().setString(3, password);
            conn.getPst().execute();

            //executes the query
            //ResultSet rs = conn.getPst().executeQuery();

            System.out.println("Registration successful!");

            Menu m = new Menu();
            m.openMenu();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
    
