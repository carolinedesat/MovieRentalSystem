/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import FileManager.FileWriter;
import FileManager.FileReader;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class RentMovie extends Login {

    private String movieid;
    private String title;
    private String collection;

    public void DisplayMovies() {
        
    FileWriter fw = new FileWriter();
    fw.WriteMovie();
    
    FileReader f = new FileReader();
    f.ReadMovie();

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
                movieid = rs.getString("movieid");
                title = rs.getString("title");
                collection = rs.getString("collection");
            }
            
            System.out.println(movieid + title + collection);

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
