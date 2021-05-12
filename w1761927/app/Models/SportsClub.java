package Models;

import java.io.Serializable;

public abstract class SportsClub  implements Serializable   {

    private String nameOfClub;
    private   String locationOfTheClub;


    public SportsClub(String nameOfClub, String locationOfTheClub) {//constructor with parameter of sportsClub
        this.nameOfClub = nameOfClub;
        this.locationOfTheClub = locationOfTheClub;


    }

    public SportsClub() { //default constructoor of sportsClub class

    }


    public String getNameOfClub() { //gettor method to get the name of the club

        return nameOfClub; //returns the name of the club
    }

    public String getLocationOfTheClub() { //gettor method to get the location of the club

        return locationOfTheClub; //returns the location of the club
    }

    public void setNameOfClub(String nameOfClub) {//settor method to set the name of the club

        this.nameOfClub=nameOfClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) {//settor method to set the location of the club
        this.locationOfTheClub=locationOfTheClub;
    }

    @Override
    public String toString() { //returns the string representation of the sportsclub
        return " " +"Name of Club : '" + nameOfClub + '\'' + ", location of the club : '" + locationOfTheClub + '\'' ;
    }


}