/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentManager;

import UserManager.Menu;
import java.util.Scanner;

/**
 *
 * @author carol
 */
public class MovieTimer {
    
    Scanner s = new Scanner(System.in);
    
    public void StartTimer(int duration) throws Exception {

        for (int i = duration; i >= 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " seconds remaining");
        }
        
        System.out.println("----------------------------------------");
        System.out.println("Your renting duration is over!");
        System.out.println("Thank you for renting a movie with EirVid. :)");
        
        Menu m = new Menu();
        m.openMenu();
    }

}
