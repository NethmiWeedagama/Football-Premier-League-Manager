package Models;

import java.util.Comparator;

public class FootBallClub  extends SportsClub implements Comparator<FootBallClub>{
    private int numOfWins;
    private int numOfDraws;
    private int numOfDefeats;
    private int numOfGoalsReceived;
    private int numOfGoalsScored;
    private int numOfPoints;
    private int numOfMatchesPlayed;




    public FootBallClub(int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsReceived,
                        int numOfGoalsScored, int numOfPoints, int numOfMatchesPlayed){
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfPoints = numOfPoints;
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }
    public FootBallClub(String nameOfClub, String locationOfTheClub, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsReceived,
                        int numOfGoalsScored, int numOfPoints, int numOfMatchesPlayed) {
        super(nameOfClub,locationOfTheClub);
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfPoints = numOfPoints;
        this.numOfMatchesPlayed = numOfMatchesPlayed;

    }

//default constructor
    public FootBallClub() {
        super();
    }



    public int getNumOfWins() {//gettor method to get the number of wins

        return numOfWins;
    }

    public int getNumOfDefeats() {//gettor method to get the number of defeats

        return numOfDefeats;
    }

    public int getNumOfDraws() { //gettor method to get the number of draws

        return numOfDraws;
    }

    public int getNumOfGoalsReceived() {//gettor method to get the number of goals received

        return numOfGoalsReceived;
    }

    public int getNumOfGoalsScored() {//gettor method to get the number of goals scored

        return numOfGoalsScored;
    }

    public int getNumOfMatchesPlayed() {//gettor method to get the number of matches played

        return numOfMatchesPlayed;
    }

    public int getNumOfPoints() { //gettor method to get the number of points

        return numOfPoints;
    }

    public void setNumOfGoalsScored(int numOfGoalsScored) { //settor method to set the number of the goals scored

        this.numOfGoalsScored = numOfGoalsScored;
    }

    public void setNumOfMatchesPlayed(int numOfMatchesPlayed) { //settor method to set the number of the matches played

        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }

    public void setNumOfWins(int numOfWins) { //settor method to set the number of the wins

        this.numOfWins = numOfWins;
    }

    public void setNumOfDefeats(int numOfDefeats) {//settor method to set the number of the defeats
        this.numOfDefeats = numOfDefeats;
    }

    public void setNumOfDraws(int numOfDraws) {//settor method to set the number of the draws

        this.numOfDraws = numOfDraws;
    }

    public void setNumOfGoalsReceived(int numOfGoalsReceived) {//settor method to set the number of the goals received
        this.numOfGoalsReceived = numOfGoalsReceived;
    }

    public void setNumOfPoints(int numOfPoints) {//settor method to set the number of the points

        this.numOfPoints = numOfPoints;
    }

    @Override
    public String toString() { //string representation of the footBallClub object
        return "\nSports Club :"+super.toString() + "\nNumber Of Wins : "+numOfWins +" \nNumber Of Draws : "+numOfDraws+"\nNumber Of Defeats : " +numOfDefeats+"\nNumber Of Goals Received : " +numOfGoalsReceived+"\nNumber Of Goals Scored : "+numOfGoalsScored+"\nNumber Of Points gained : " +numOfPoints+"\nNumber Of Matches Played : " +numOfMatchesPlayed;

    }

    @Override
    public int compare(FootBallClub club1,FootBallClub club2) {

        if(club1.getNumOfPoints() < club2.getNumOfPoints()){
            return 1;
        } else if (club1.getNumOfPoints() > club2.getNumOfPoints()) {
            return -1;
        } else {
            int difference1 = club1.getNumOfGoalsScored() - club1.getNumOfGoalsReceived();
            int difference2 = club2.getNumOfGoalsScored() - club2.getNumOfGoalsReceived();
            if (difference1 < difference2)
                return 1;
            else if (difference1 > difference2)
                return -1;
            else return 0;
        }
    }


}