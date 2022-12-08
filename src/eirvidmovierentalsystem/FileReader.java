/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Heber https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/
 */
public class FileReader {

public static void main(String[] args) throws IOException
    {
        // variable declaration
        int ch;
 
        // check if File exists or not
        FileReader fr = null;
        fr = new FileReader("text");
 
        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);
 
        // close the file
        fr.close();
    }

    private FileReader(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
