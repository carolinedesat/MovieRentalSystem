/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

import SQL.SQLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yan Oliveira 2020336
 */
public class Register extends Menu {

    private String username;
    private String password;

    public void Register() {

        //outputs the register page
        System.out.println("----------------------------------------");
        System.out.println("[REGISTRATION PAGE]");
        System.out.println("Please enter your username:");
        username = s.nextLine(); //stores the user input inside the "username" variable
        System.out.println("Please enter your password:");
        password = s.nextLine(); //stores the user input inside the "password" variable

        try {

            //loads the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //retrieves and stores the query
            String query = "INSERT INTO customers (username, password) VALUES (?, ?)";

            //gets a statement from the connection
            conn.prepareStatement(query);

            //passses the parameters
            conn.getPst().setString(1, username);
            conn.getPst().setString(2, password);
            conn.getPst().execute();

            System.out.println("----------------------------------------");
            System.out.println("Registration successful!");

            //opens the menu again so the user can login
            Menu m = new Menu();
            m.openMenu();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
