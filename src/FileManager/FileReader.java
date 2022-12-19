/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author carol
 */
public class FileReader {
    
    private String movieid;
    private String title;
    private String collection;

    public void ReadMovie() {

        String csvFile = "Movie_Metadata_Edited_2.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] movie = line.split(cvsSplitBy);
                movieid = movie[5];
                title = movie[1];
                collection = movie[2];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
