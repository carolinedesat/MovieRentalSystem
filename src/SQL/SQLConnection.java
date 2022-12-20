/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Caroline de Sa, 2020331
 */
public class SQLConnection {
    
    String servername = "localhost:3306"; //Database server path
    String dataName = "login"; // Database name
    String url = "jdbc:mysql://" + servername + "/" + dataName;
    String username = "root"; //DB User Name
    String password = "*Dun04061620"; // DB Password
    Connection connection; //Attribut to make the connection
    PreparedStatement pst;
    
    public SQLConnection(){
       
        try{ 
            this.connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println("SQL Error --> ");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());//this will print out the exact message from the DB error
        }
    }
    
    public void prepareStatement(String query){
        try{
            this.pst = connection.prepareStatement(query);
        }catch(SQLException e){
            System.out.println("SQL Error --> ");
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());//this will print out the exact message from the DB error
        }
    }

    public PreparedStatement getPst() {
        return pst;
    }
    
}
