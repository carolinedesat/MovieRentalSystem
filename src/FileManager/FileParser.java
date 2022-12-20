/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import SQL.SQLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caroline de Sa, 2020331
 */
public class FileParser {

    //CSV file header
    private static final String[] FILE_HEADER_MAPPING = {"title", "price"};

    public void ParseFile(String fileName) {

        BufferedReader fileReader = null;

        try {
            //creates the list of movies
            List<Movies> movies = new ArrayList<>();

            String line;

            //creates the file reader
            fileReader = new BufferedReader(new java.io.FileReader(fileName));

            //reads the first row of the CSV file and skips it
            fileReader.readLine();

            //reads the file line by line
            while ((line = fileReader.readLine()) != null) {
                //gets all the data available in the line
                String[] data = line.split(",");
                if (data.length > 0) {
                    //creates a new movie object using the class "Movies" 
                    //and fills the data according to its index
                    Movies movie = new Movies(data[1], data[10]);
                    //adds the movie
                    movies.add(movie);
                }
            }

            //gets a connection to the database
            SQLConnection conn = new SQLConnection();

            //passses all the parameters
            for (Movies movie : movies) {
                String query = "INSERT INTO movies (title, price) VALUES (?,?)";
                conn.prepareStatement(query);
                conn.getPst().setString(1, movie.getTitle());
                conn.getPst().setString(2, movie.getPrice());
                conn.getPst().executeUpdate();
            }

            //runs the file display
            FileDisplay fd = new FileDisplay();
            fd.DisplayFile();

        } catch (Exception e) {
            System.out.println("Error reading the csv file");
            e.printStackTrace();
            
        } finally {
            
            try {
                fileReader.close();
                
            } catch (IOException e) {
                System.out.println("Error closing the csv file");
                e.printStackTrace();
            }
        }
    }

}
