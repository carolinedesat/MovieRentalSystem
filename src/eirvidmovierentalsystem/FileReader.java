/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Heber https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/
 */
public class FileReader {

public static void main(String[] args) {
    
        String csvFile = "movies_metadata.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] movie = line.split(cvsSplitBy);
                System.out.println("MOVIE: " + movie[5] + movie[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
