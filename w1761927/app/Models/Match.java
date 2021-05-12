package Models;

import java.io.Serializable;

public class Match implements  Serializable {

    private FootBallClub teamOne;
    private FootBallClub teamTwo;
    private int scoreTeamOne;
    private int scoreTeamTwo;
    private Dates dates;

    public  Match(){}  //default constructor  of Match class

    public Match(FootBallClub teamOne,FootBallClub teamTwo,int scoreTeamOne,int scoreTeamTwo,Dates dates){ //constructor with parameters of Match class
        this.teamOne=teamOne;
        this.teamTwo=teamTwo;
        this.scoreTeamOne=scoreTeamOne;
        this.scoreTeamTwo=scoreTeamTwo;
        this.dates=dates;
    }


    public FootBallClub getTeamOne() {//gettor method to get the team one
        return teamOne;
    }

    public FootBallClub getTeamTwo() { //gettor method to get the  team two
        return teamTwo;
    }

    public int getScoreTeamOne() { //gettor method to get the team one score
        return scoreTeamOne;
    }

    public int getScoreTeamTwo() {
        return scoreTeamTwo;
    } //gettor method to get the team two score

    public Dates getDates() { //gettor method to get the dates
        return dates;
    }

    public void setTeamOne(FootBallClub teamOne) {  //settor method to set the team one
        this.teamOne = teamOne;
    }

    public void setTeamTwo(FootBallClub teamTwo) {//settor method to set the team two
        this.teamTwo = teamTwo;
    }

    public void setScoreTeamOne(int scoreTeamOne) {//settor method to set the team one score
        this.scoreTeamOne = scoreTeamOne;
    }

    public void setScoreTeamTwo(int scoreTeamTwo) {//settor method to set the team two score
        this.scoreTeamTwo = scoreTeamTwo;
    }

    public void setDates(Dates dates) {//settor method to set the dates
        this.dates = dates;
    }

    @Override
    public String toString() {  //returns the string representation of the match object
        return "\nMatch :" + "\nteamOne=" + teamOne.getNameOfClub() + ", \nteamTwo=" + teamTwo.getNameOfClub() + ",\n scoreTeamOne=" + scoreTeamOne + ", scoreTeamTwo=" + scoreTeamTwo + ", dates='" + dates.toString() + '\'' +
                '}';
    }


}
