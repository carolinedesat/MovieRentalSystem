/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

/**
 *
 * @author Caroline de Sa, 2020331
 */
public class Movies {

    private String movieid;
    private String title;
    private String price;

    //constructor
    public Movies(String title, String price) {
        this.title = title;
        this.price = price;
    }

    //getters and setters
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

}
