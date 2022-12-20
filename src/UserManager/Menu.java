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

    public void OpenMenu() throws Exception {

        //outputs the menu
        System.out.println("----------------------------------------");
        System.out.println("[MENU]");
        System.out.println("Select one of the following options:");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("----------------------------------------");
        int sign = s.nextInt(); //stores the user input inside the "sign" variable

        //validates the user input to be a number between 1 and 2
        if (sign < 1 || sign > 3) {
            System.out.println("Invalid option. Please try again.");
            //opens the menu again if the user input is invalid
            OpenMenu();

        } else {

            switch (sign) {
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
                    OpenMenu();
            }
        }
    }
}
