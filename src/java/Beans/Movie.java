/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author GIG
 */
public class Movie {

    String movieName ,releaseDate, description,startDate,endDate;
    float rate;
    double price;
    boolean isRented;
    int ID;

    public Movie(String movieName, String releaseDate, String description, String startDate, String endDate, float rate, double price, boolean isRented) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.price = price;
        this.isRented = isRented;
    }

    
    public Movie(String movieName, String releaseDate, String description,float rate, double price,boolean isRented) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.price = price;
        this.isRented=isRented;
    }
public Movie(int ID, String movieName, String releaseDate, String description, float rate, double price) {
        this.ID = ID;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.description = description;
        this.rate = rate;
        this.price = price;
    }

    public Movie(int ID, String movieName, String releaseDate, String description, float rate, double price, boolean isRented) {
        this.ID = ID;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.description = description;
        this.rate = rate;
        this.price = price;
        this.isRented = isRented;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
