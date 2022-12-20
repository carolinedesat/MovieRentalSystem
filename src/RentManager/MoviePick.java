/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentManager;

import SQL.SQLConnection;
import UserManager.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author carol
 */
public class MoviePick {
    
    Login l = new Login();

    public void PickMovie() {

        Scanner s = new Scanner(System.in);
        System.out.println("------------ EirVid ------------");
        System.out.print("Enter the ID of the movie you want to pick: ");
        System.out.println("----------------------------------------");
        int id = s.nextInt();

        // Select the record with the specified ID
        String pickMovie = "SELECT * FROM movies WHERE movieid = ?";
        try {

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //gets a statement from the connection
            conn.prepareStatement(pickMovie);

            conn.getPst().setInt(1, id);
            ResultSet rs = conn.getPst().executeQuery();
            if (rs.next()) {
                // Print the contents of the record
                System.out.println("ID: " + rs.getInt("movieid"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Price: " + rs.getString("price"));
                // etc.
            } else {
                System.out.println("No record with ID " + id + " was found.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query.");
            e.printStackTrace();
        }

    }
}
