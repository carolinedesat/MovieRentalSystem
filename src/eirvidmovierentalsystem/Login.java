/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import FileManager.FileParser;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yan Oliveira 2020336
 */
public class Login extends Menu {

    public int userid;
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

            FileParser fp = new FileParser();
            fp.parseFile("Movie_Metadata_Edited_2.csv");

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
