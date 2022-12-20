/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

import java.util.Scanner;

/**
 *
 * @author Yan Oliveira 2020336
 */
public class Menu {

    //reads the user input
    Scanner s = new Scanner(System.in);

    public void openMenu() throws Exception {

        //outputs the menu
        System.out.println("----------------------------------------");  
        System.out.println("[MENU]");
        System.out.println("Select one of the following options:");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("----------------------------------------");

        //stores the user input inside the "sign" variable
        String sign = s.next();

        if (!sign.matches("[0-9]+")) {
            System.out.println("----------------------------------------");
            System.out.println("ERROR");
            System.out.println("----------------------------------------");

            //opens the menu again if the user input is not a number
            openMenu();

        } else {

            switch (Integer.parseInt(sign)) {
                case 1: //opens the login page when the user types the number 1
                    Login l = new Login();
                    l.Login();
                    break;

                case 2: //opens the register page if the user types the number 2
                    Register r = new Register();
                    r.Register();
                    break;

                default:
                    System.out.println("----------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("----------------------------------------");
                    //opens the menu again if the user input is not 1 or 2
                    openMenu();
            }
        }
    }
}
