/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import SQL.SQLConnection;
import UserManager.Register;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caroline de Sa, 2020331
 */
public class FileDisplay {
    
    FileParser fp = new FileParser();

    public void DisplayFile() {

        try {

            //loads the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //retrieves and stores the query
            String displayMovie = "SELECT * FROM movies";

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //gets a statement from the connection
            conn.prepareStatement(displayMovie);

            //executes the query
            ResultSet rs = conn.getPst().executeQuery();

            while (rs.next()) {
                int movieid = rs.getInt("movieid");
                String title = rs.getString("title");
                String price = rs.getString("price");

                System.out.println("The available movies are:");
                System.out.println("ID: " + movieid + " | " + "Title: " + title + " | " + "Price: " + price);
            }

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}