package Models;

public class UniversityFootballClub extends FootBallClub{
    private int numOfMembers;
    private String nameOfTheUniversity;

//constructor with parameters
    public UniversityFootballClub(String nameOfClub, String locationOfTheClub, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsReceived,
                                  int numOfGoalsScored, int numOfPoints, int numOfMatchesPlayed,int numOfMembers,String nameOfTheUniversity) {
        super(nameOfClub, locationOfTheClub, numOfWins, numOfDraws, numOfDefeats, numOfGoalsReceived, numOfGoalsScored, numOfPoints, numOfMatchesPlayed);
        this.numOfMembers=numOfMembers;
        this.nameOfTheUniversity=nameOfTheUniversity;


    }

    public String getNameOfTheUniversity() { //gettor method to get the name of the university

        return nameOfTheUniversity; //returns the name of the university
    }

    public void setNameOfTheUniversity(String nameOfTheUniversity) { //settor method to set the name of the university

        this.nameOfTheUniversity = nameOfTheUniversity;
    }

    public int getNumOfMembers() { //gettor method to get the number of members

        return numOfMembers; //returns the number of members
    }

    public void setNumOfMembers(int numOfMembers) {//settor method to set the number of the members

        this.numOfMembers = numOfMembers;
    }
}