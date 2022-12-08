/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import SQL.SQLConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heber
 * https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/
 */
public class FileWriter {

    private String movie;
    private String price;

    public static void main(String[] args) throws IOException {

        String str = "";

        FileWriter fw = new FileWriter("movies_metadata.csv");

        for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }

        System.out.println("Writing successful");

        fw.close();
        
    }

    private void databaseConnection() {
        try {

            //loads the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //retrieves and stores the query
            String insertMovie = "INSERT INTO movies (movie, price) VALUES (?, ?, ?)";

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //gets a statement from the connection
            conn.prepareStatement(insertMovie);

            //passses all the parameters
            conn.getPst().setString(1, movie);
            conn.getPst().setString(2, price);

            //executes the query
            ResultSet rs = conn.getPst().executeQuery();

            System.out.println("File writer successful!");

            Menu m = new Menu();
            m.openMenu();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private FileWriter(String moviescsv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void write(char charAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
