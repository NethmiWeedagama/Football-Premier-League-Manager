package Models;

public class SchoolFootballClub extends FootBallClub {
    private String nameOfTheCoach;
    private String nameOfSchool;


    //constructor with parameters
    public SchoolFootballClub(String nameOfClub, String locationOfTheClub, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsReceived,
                              int numOfGoalsScored, int numOfPoints, int numOfMatchesPlayed, String nameOfTheCoach,String nameOfSchool) {
        super(nameOfClub, locationOfTheClub, numOfWins, numOfDraws, numOfDefeats, numOfGoalsReceived, numOfGoalsScored, numOfPoints, numOfMatchesPlayed);
        this.nameOfTheCoach=nameOfTheCoach;
        this.nameOfSchool=nameOfSchool;

    }
    public String getNameOfSchool(){//gettor method to get the name of the school

        return nameOfSchool; //returns the name of the school
    }

    public void setNameOfSchool(String nameOfSchool) {//settor method to set the name of the school

        this.nameOfSchool = nameOfSchool;
    }

    public String getNameOfTheCoach() { //gettor method to get the name of the coach
        return nameOfTheCoach;//returns the name of the coach
    }

    public void setNameOfTheCoach(String nameOfTheCoach) { //settor method to set the name of the coach

        this.nameOfTheCoach = nameOfTheCoach;
    }
}