/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentManager;

import SQL.SQLConnection;
import UserManager.Register;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class MoviePick {

    Scanner s = new Scanner(System.in);

    public void PickMovie() {

        //outputs the movie pick page
        System.out.println("----------------------------------------");
        System.out.println("[EIRVID MOVIE RENTAL]");
        System.out.print("Enter the ID of the movie you want to pick: ");
        int movieid = s.nextInt(); //stores the user input inside the "movieid" variable

        //retrieves and stores the query
        String query = "SELECT * FROM movies WHERE movieid = ?";
        
        try {

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //gets a statement from the connection
            conn.prepareStatement(query);

            //passses all the parameters
            conn.getPst().setInt(1, movieid);
            
            //executes the query
            ResultSet rs = conn.getPst().executeQuery();
            
            if (rs.next()) {
                //retrieves movieid, title and price from the SQL database
                //and prints them to the console
                System.out.println("----------------------------------------");
                System.out.println("ID: " + rs.getInt("movieid"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Price: " + rs.getString("price"));
                System.out.println("----------------------------------------");

            } else {
                System.out.println("No record with ID " + movieid + " was found.");
                PickMovie(); //opens the pick movie page again if the user input is not valid
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
