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
                //retrieves title and price from the SQL database
                //and prints them to the console
                System.out.println("----------------------------------------");
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Price: " + rs.getString("price"));
                System.out.println("----------------------------------------");
                //outputs the rental duration options
                System.out.println("Select a rental duration:");
                System.out.println("1) 1 minute");
                System.out.println("2) 5 minutes");
                System.out.println("3) 10 minutes");
                System.out.println("----------------------------------------");
                int duration = s.nextInt(); //stores the user input inside the "duration" variable

                //validates the user input to be a number between 1 and 3
                if (duration < 1 || duration > 3) {
                    System.out.println("Invalid duration. Please try again.");
                    return;
                }

                int durationInSeconds = 0;

                //rents the selected movie for the selected duration
                if (duration == 1) {
                    durationInSeconds = 60;
                } else if (duration == 2) {
                    durationInSeconds = 300;
                } else if (duration == 3) {
                    durationInSeconds = 600;
                }

                System.out.println("You have rented [" + rs.getString("title") + "] for " + durationInSeconds / 60 + " minutes.");
                System.out.println("----------------------------------------");

                //starts the timer
                MovieTimer mt = new MovieTimer();
                mt.StartTimer(durationInSeconds);

            } else {
                System.out.println("No record with ID " + movieid + " was found.");
                PickMovie(); //opens the pick movie page again if the user input is not valid
            }

        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
