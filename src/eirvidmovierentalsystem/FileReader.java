/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heber
 * https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/
 */
public class FileReader {

    private String movieid;
    private String title;
    private String collection;

    public void ReadMovie() {

        String csvFile = "movies_metadata.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFile))) {
            
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] movie = line.split(cvsSplitBy);
                movieid = movie[5];
                title = movie[6];
                collection = movie[2];
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void WriteMovie() {
 
        try {

                //loads the database driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //gets a connection to the database
                SQLConnection conn = new SQLConnection();

                //retrieves and stores the query
                String insertMovie = "INSERT INTO movies (movieid, title, collection) VALUES (?, ?, ?)";

                //gets a statement from the connection
                conn.prepareStatement(insertMovie);

                //passses the parameters
                conn.getPst().setString(1, movieid);
                conn.getPst().setString(2, title);
                conn.getPst().setString(1, collection);
                conn.getPst().execute();

            System.out.println("Movie written into the database!");

            Menu m = new Menu();
            m.openMenu();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
