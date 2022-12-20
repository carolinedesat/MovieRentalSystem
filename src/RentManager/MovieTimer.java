/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentManager;

/**
 *
 * @author carol
 */
public class MovieTimer {
    
    public void StartTimer(int duration) {

        for (int i = duration; i >= 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " seconds remaining!");
        }
        System.out.println("Time's up!");
    }

}
