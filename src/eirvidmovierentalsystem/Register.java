/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yan Oliveira 2020336
 */
public class Register extends Menu {
    
    private int userid;
    private String username;
    private String password;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Register() {

        System.out.println("---------- REGISTRATION PAGE ----------");

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
            String insertUser = "INSERT INTO customers (username, password) VALUES (?, ?)";

            //gets a statement from the connection
            conn.prepareStatement(insertUser);

            //passses the parameters
            conn.getPst().setString(1, username);
            conn.getPst().setString(2, password);
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
