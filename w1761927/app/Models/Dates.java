package Models;

import java.io.Serializable;

public class Dates implements Serializable  {
    private int year;
    private int month;
    private int date;



    public Dates(int date, int month, int year) { //constructor with parameters
        this.year = year;
        this.month = month;
        this.date = date;

    }



    public int getDay() { //gettor method to get the day

        return date;   //returns the date
    }

    public void setDay(int day) {  //settor method to set the day

        this.date= day;
    }

    public int getMonth() {//gettor method to get the month

        return month; //returns  the month
    }

    public void setMonth(int month) { //settor method to set the month

        this.month = month;
    }

    public int getYear() {//gettor method to get the year

        return year;//returns the  year
    }

    public void setYear(int year) {//settor method to set the year

        this.year = year;
    }

    @Override
    public String toString() {
        return date +"/"+ month +"/"+ year ;  //returns the string representation of the dates object
    }


    public int compareTo(Dates dates) {
        return 0;
    }
}