/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yan Oliveira 2020336
 */
public class Login extends Menu {

    private String username;
    private String password;

    public void Login() {

        System.out.println("---------- LOGIN PAGE ----------");
        System.out.println("Please enter your username:");
        username = s.nextLine();
        System.out.println("Please enter your password:");
        password = s.nextLine();

        try {

            //loads the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //retrieves and stores the query
            String query = "SELECT * FROM customers WHERE username=? and password=?";

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //gets a statement from the connection
            conn.prepareStatement(query);

            //passses all the parameters
            conn.getPst().setString(1, username);
            conn.getPst().setString(2, password);

            //executes the query
            ResultSet rs = conn.getPst().executeQuery();

            System.out.println("Login successful!");

            Menu m = new Menu();
            m.openMenu();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
