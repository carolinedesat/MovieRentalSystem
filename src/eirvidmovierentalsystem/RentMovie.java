/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import FileManager.FileReader;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class RentMovie {

    FileReader fr = new FileReader();

    public void DisplayMovies() {

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

            //adds the usernames to the list
            while (rs.next()) {
                fr.setTitle(rs.getString("movieid"));
                fr.setPrice(rs.getString("title"));
            }
            
            System.out.println(fr.getTitle() + fr.getPrice());

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
