/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import SQL.SQLConnection;
import eirvidmovierentalsystem.Menu;
import eirvidmovierentalsystem.Register;
import eirvidmovierentalsystem.RentMovie;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class FileWriter {
    
    FileReader fr = new FileReader();

    public void WriteMovie() {

        try {

            //loads the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //retrieves and stores the query
            String insertMovie = "INSERT INTO movies (title, price) VALUES (?, ?)";

            //gets a statement from the connection
            conn.prepareStatement(insertMovie);

            //passses the parameters
            conn.getPst().setString(1, fr.getTitle());
            conn.getPst().setString(2, fr.getPrice());

            System.out.println("Movie written into the database!");

            RentMovie r = new RentMovie();
            r.DisplayMovies();

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}