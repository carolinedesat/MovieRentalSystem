/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvidmovierentalsystem;

/**
 *
 * @author Carol de Sa Teixeira – 2020331
 * @author Yan Oliveira 2020336
 */
public class EirVidMovieRentalSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Menu m = new Menu();
        m.openMenu();

        Login l = new Login();
       l.Login();

       Register r = new Register();
       r.Register();

    }
}
