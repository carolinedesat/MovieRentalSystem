/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import FileManager.FileParser;
import SQL.SQLConnection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class RentMovie {

    FileParser fp = new FileParser();

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

            if (rs.next()) {
                
                //String username = rs.getString("username");

                rs.getString("title");
                rs.getString("price");

            } else {

                System.out.println("ERROR DISPLAYING");

            }

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
