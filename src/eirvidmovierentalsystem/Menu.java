/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

import java.util.Scanner;

/**
 *
 * @author carol
 */
public class Menu {

    Scanner s = new Scanner(System.in);

    public void openMenu() throws Exception {

        System.out.println("----------------------------------------");
        System.out.println("Select one of the following options:");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("----------------------------------------");

        String sign = s.next();

        if (!sign.matches("[0-9]+")) {
            System.out.println("----------------------------------------");
            System.out.println("ERROR");
            System.out.println("----------------------------------------");

            openMenu();

        } else {

            switch (Integer.parseInt(sign)) {
                case 1:
                    //Login l = new Login();
                    //l.Login();
                    break;

                case 2:
                    //Register r = new Register();
                    //r.Register();
                    break;

                default:
                    System.out.println("----------------------------------------");
                    System.out.println("Not a valid option!");
                    System.out.println("----------------------------------------");
                    openMenu();
            }
        }
    }
}
