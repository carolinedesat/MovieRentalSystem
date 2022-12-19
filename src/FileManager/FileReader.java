/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public class FileReader {
    
    private String movieid;
    private String title;
    private String price;

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void ReadMovie() {
        
        String csvFile = "Movie_Metadata_Edited_2.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] movie = line.split(cvsSplitBy);
                this.title = movie[1];
                this.price = movie[10];
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
