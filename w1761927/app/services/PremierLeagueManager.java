package services;

import Models.Dates;
import Models.FootBallClub;
import Models.Match;
import Models.SortDateComparator;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager  implements LeagueManager {
    private static PremierLeagueManager instances;//created a instance
    private final int MAXIMUM_CLUBS = 20;  //maximum number of football clubs  in the premier league is 20
    static final List<FootBallClub> footBallClubList = new ArrayList<>(); //arraylist that stores the details of the football clubs
    final ArrayList<Match> listOfMatches = new ArrayList<Match>(); //arraylist that stores the details of the matches


    public static PremierLeagueManager getInstance(){
        instances=new PremierLeagueManager();
        return instances;
    }

    public  List<FootBallClub> getFootBallClubList() throws IOException,ClassNotFoundException{
        loadFile("footBallClubsFile.ser","matchPlayedFile.ser");
        return footBallClubList;
    }

    public  ArrayList<Match> getMatchList() throws IOException,ClassNotFoundException{
        loadFile("footBallClubsFile.ser","matchPlayedFile.ser");
        return listOfMatches;
    }

    public List<FootBallClub> sortTableFootballClubPoints() {//method to sort table by the points
        ArrayList<FootBallClub> clubData =new ArrayList<>();
            clubData.addAll(footBallClubList)  ;
        Comparator<FootBallClub> columnComparator1 =
                (FootBallClub club1, FootBallClub club2) -> {
                    if(club1.getNumOfPoints() < club2.getNumOfPoints()){
                        return 1;
                    } else if (club1.getNumOfPoints() > club2.getNumOfPoints()) {
                        return -1;
                    } else {
                        return 0;
                    }
                };

        Collections.sort(clubData, columnComparator1);
        return clubData;
    }
    public List<FootBallClub> sortTableFootballClubWin() {//method to sort table by the wins
        ArrayList<FootBallClub> clubData =new ArrayList<>();
        clubData.addAll(footBallClubList)  ;
        Comparator<FootBallClub> columnComparator3 =
                (FootBallClub club1, FootBallClub club2) -> {
                    if(club1.getNumOfWins() < club2.getNumOfWins()){
                        return 1;
                    } else if (club1.getNumOfWins() > club2.getNumOfWins()) {
                        return -1;
                    } else {

                        return 0;
                    }

                };

        Collections.sort(clubData,columnComparator3);
        return clubData;
    }

    public List<FootBallClub> sortTableFootballClubGoals() { //method to sort table by the goals scored
        ArrayList<FootBallClub> clubData =new ArrayList<>();
        clubData.addAll(footBallClubList)  ;

        Comparator<FootBallClub> columnComparator2=
                (FootBallClub club1, FootBallClub club2) -> {
                    if(club1.getNumOfGoalsScored() < club2.getNumOfGoalsScored()){
                        return 1;
                    } else if (club1.getNumOfGoalsScored() > club2.getNumOfGoalsScored()) {
                        return -1;
                    } else {

                        return 0;
                    }


                };

        Collections.sort(clubData, columnComparator2);


        return clubData;



    }
    public List<Match> sortTableMatchDate() { //method is used to sort table by date
        ArrayList<Match> matchData =new ArrayList<>();
        matchData.addAll(listOfMatches)  ;
        Collections.sort(matchData, new SortDateComparator());
        return matchData;
    }

    public List<Match> searchTableMatch(String filterDate) { //method to search the matches by date

          ArrayList<Match> matchData = new ArrayList<>();

            for (Match matchObject : listOfMatches) {
                if (String.valueOf(matchObject.getDates()).equals(filterDate)) {
                    matchData.add(matchObject);
                }
            }
        return matchData;
    }
    @Override
    public void removeFootBallClub(String input) { //this method is used to delete the football club from the premeir league

        for (FootBallClub club : footBallClubList) {
            if (club.getNameOfClub().toLowerCase().equals(input)) { //check whether there are clubs that is equal to the user entered  club name
                footBallClubList.remove(club);
                System.out.println("Club " + club.getNameOfClub() + "  is deleted successfully");
                return;
            }
        }

        System.out.println("No such club in the football premier league");
        return;
    }

    public void deleteAll() { //this method is used to delete the football club from the premeir league

        footBallClubList.clear();
        listOfMatches.clear();



    }
    @Override
    public void addFootBallClub( FootBallClub footballClub) { //this methos is used to add a footballclub to the premeir league

        try {
            if (footBallClubList.size() == MAXIMUM_CLUBS) {  //checks whether the premier league is full with 20 clubs
                System.out.println("Can't add more clubs to Premier league!");
                return;
            }
            for(FootBallClub clubs :footBallClubList){
                if(clubs.getNameOfClub().toLowerCase().equals(footballClub.getNameOfClub().toLowerCase())){//   checks whether the  user club is already in the premier league
                    System.out.println("The  football club  already exists in the premier league.");
                    return;
                }

            }


            footBallClubList.add(footballClub); //add the footballclub object to the arraylist
            System.out.println("Football club is succesfully added");

        } catch (Exception e) {
            System.out.println(" Enter a valid Input.");
        }
    }
    public void showAvailableClubs(){ //this method shows the available clubs in the premeir league
        System.out.println("Available clubs :");
        for (int index = 0; index < footBallClubList.size(); index++) {
            System.out.println(" Club "+footBallClubList.get(index).getNameOfClub() + "   ");//prints all the names of the clubs in the premier league
        }
        System.out.println("------------------------");
    }


    @Override
    public void viewStatistics(String input) { //this method is used to show the statistics of each individual team

        for (FootBallClub club : footBallClubList) {
            if (club.getNameOfClub().toLowerCase().equals(input)) { //check whether the club in the  arraylist is equal to the user entered club name and show the relevant statistics
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of matches won    :      " + club.getNumOfWins());
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of matches lost   :      " + club.getNumOfDefeats());
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of matches draw   :      " + club.getNumOfDraws());
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of goals scored   :      " + club.getNumOfGoalsScored());
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of goals recieved :      " + club.getNumOfGoalsReceived());
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of points         :      " + club.getNumOfPoints());
                System.out.println(club.getNameOfClub() + "  Club  |" + " Number of matches played :      " + club.getNumOfMatchesPlayed());
                return;
            }
        }
        System.out.println("Club is not in the premier league");
    }

    @Override
    public void addPlayedMatch(String dateInput,String input1,String input3,String input2,String input4) { //this method is used to add a played match in the premeir league

        FootBallClub team1 = null;
        FootBallClub team2 = null;
        int day = 0;
        int month = 0;
        int year = 0;

        String temp[];



        temp = dateInput.split("/");//separates these day, month using splitter function
        day = Integer.parseInt(temp[0]);
        if (day < 32 && day > 0){ //check the user enter day is correct
            month = Integer.parseInt(temp[1]);
            if (month > 0 && month < 13){ //check the user enter month is correct
                year = Integer.parseInt(temp[2]);
            } else {
                System.out.println("Invalid month..Please enter the correct month");
                return;

            }
        } else {
            System.out.println("Invalid Day..Please enter the correct date");
            return;
        }
        Dates date =new Dates(day,month,year);
        //check  whether the name of the club that user input  is equal with the names of the clubs in the arraylist that contains the football  club details
        for (int i = 0; i < footBallClubList.size(); i++) {
            if (footBallClubList.get(i).getNameOfClub().equals(input1))
                team1 = footBallClubList.get(i);
        }
        if (team1 == null) {//check whether the team 1 is not in the premeir league
            System.out.println("Team 1  club  is not in the  football premeir league ");
            return;
        }
        int goals1=0;
        try {
            goals1 = Integer.parseInt(input3);
        } catch (Exception e) {
            System.out.println("Invalid input for team 1 goals..Please enter an integer value");
            return;
        }
        if (goals1 <0) {//check whether a  goals score of team 1 is a positive value
            System.out.println("Number of goals can,t be a minus value.You have to enter the number of goals");
            return;
        }
        //check  whether the name of the club that user input  is equal with the names of the clubs in the arraylist that contains the football  club details
        for (int i = 0; i < footBallClubList.size(); i++) {
            if (footBallClubList.get(i).getNameOfClub().equals(input2))
                team2 = footBallClubList.get(i);
        }
        if (team2 == null) { //check whether the team 2 is not in the premeir league
            System.out.println("Team 2 club  is not in the  football premeir league ");
            return;
        }
        int goals2=0;
        try {
            goals2 = Integer.parseInt(input4);
        } catch (Exception e) {
            System.out.println("Invalid input for team 2 goals..Please enter an integer value");
            return;
        }
        if (goals2 <0) { //check whether a  goals score  of team 2 is a positive value
            System.out.println("Number of goals can,t be a minus value.You have to enter the number of goals");
            return;
        }

        Match match = new Match();
        match.setDates(date);
        match.setTeamOne(team1);
        match.setTeamTwo(team2);
        match.setScoreTeamOne(goals1);
        match.setScoreTeamTwo(goals2);
        listOfMatches.add(match);  // add the object match to the arraylist that contains details about the matches
        team1.setNumOfGoalsScored(team1.getNumOfGoalsScored() + goals1);
        team1.setNumOfMatchesPlayed(team1.getNumOfMatchesPlayed() + 1);
        team1.setNumOfGoalsReceived(team1.getNumOfGoalsReceived()+goals2);
        team2.setNumOfGoalsScored(team2.getNumOfGoalsScored() + goals2);
        team2.setNumOfMatchesPlayed(team2.getNumOfMatchesPlayed() + 1);
        team2.setNumOfGoalsReceived(team2.getNumOfGoalsReceived()+goals1);
        if (goals1 > goals2) {        //to check team 1 wins
            team1.setNumOfPoints(team1.getNumOfPoints()+3); //add 3 points to the  team 1
            team1.setNumOfWins(team1.getNumOfWins()+1);//add 1 to the number of wins in team 1
            team2.setNumOfDefeats(team2.getNumOfDefeats()+1);//add 1 to the number of defeats in team 2
        }else if (goals1 < goals2) {     //checks that team 2 wins
            team1.setNumOfDefeats(team1.getNumOfDefeats()+1);//add 1 to the number of defeats in team 1
            team2.setNumOfPoints(team2.getNumOfPoints()+3);//add 3 points to the team2
            team2.setNumOfWins(team2.getNumOfWins()+1);//add 1 to the number of wins in team 2
        } else {  //checks whether the match is draw
            team1.setNumOfPoints(team1.getNumOfPoints()+1);//add 1 point to the team 1
            team1.setNumOfDraws(team1.getNumOfDraws()+1);// add 1 to the number of defeats in team 1
            team2.setNumOfPoints(team2.getNumOfPoints()+1);//add 1 point to the team 2
            team2.setNumOfDraws(team2.getNumOfDraws()+1);// add 1 to the number of defeats in team 2
        }
    }

    @Override
    public void displayPrimierLeagueTable() { //this method is used to show the statistics of each team in the premeir league table

        // Print the list football club details in tabular format.
        Collections.sort(footBallClubList,new FootBallClub());
        System.out.println("_________________________________________________________________________________________________________________________________________|");
        System.out.println("                                                              PREMIER LEAGUE  TABLE                                                      |");
        System.out.println("_________________________________________________________________________________________________________________________________________|");
        System.out.println("club Name             | points   |  goal difference  |  wins | defeats | draws  |  matches played   |   goals scored |   goals received  |");
        System.out.println();
        System.out.println("_________________________________________________________________________________________________________________________________________|");
        for (FootBallClub club : footBallClubList) {
            System.out.format("%-21s | %-8d | %-17d |%-6d |%-8d |%-8d |%-17d |%-15d |%-18d |", club.getNameOfClub(), club.getNumOfPoints(), (club.getNumOfGoalsScored() - club.getNumOfGoalsReceived()), club.getNumOfWins(), club.getNumOfDefeats(), club.getNumOfDraws(), club.getNumOfMatchesPlayed(), club.getNumOfGoalsScored(), club.getNumOfGoalsReceived());//gets the statistics of the teams
            System.out.println();
        }
        System.out.println("_________________________________________________________________________________________________________________________________________|");
    }
    public void save() throws IOException { //this method is used to save the football club list and match list
        // Serialization

        try {
            FileOutputStream fileOut = new FileOutputStream("footBallClubsFile.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (FootBallClub club : footBallClubList) {
                out.writeObject(club);
            }
            out.flush();
            out.close();
            fileOut.close();
            System.out.println("\nfootball club is saved successfully... Checkout your specified output file..\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }
        try {
            FileOutputStream fileOut1 = new FileOutputStream("matchPlayedFile.ser");
            ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
            for (Match club : listOfMatches) {
                out1.writeObject(club);
            }
            out1.flush();
            out1.close();
            fileOut1.close();
            System.out.println("\nMatch is saved Successful... Checkout your specified output file..\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException is caught");
        }


    }
    public void loadFile(String clubFile,String matchFile) throws IOException { //this method is used to load the data saved in the files
// Deserialization
        try {
            FileInputStream fileInputStream = new FileInputStream(clubFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            footBallClubList.clear(); //clear the arraylist before adding the data saved  in the file
            for (; ; ) { //uses infinite loop
                try {
                    footBallClubList.add((FootBallClub) objectInputStream.readObject()); //add the  footballclub data in the file to the araylist
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
            fileInputStream.close();
            objectInputStream.close();

            System.out.println("football clubs have been loaded successfully");
            System.out.println(footBallClubList);

            FileInputStream fileIn1 = new FileInputStream(matchFile);
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            listOfMatches.clear();//clear the arraylist before adding the data saved  in the file
            for (; ; ) {//uses a infinite loop
                try {
                    listOfMatches.add((Match) in1.readObject());//add the match data in the file to the araylist
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
            fileIn1.close();
            in1.close();

            System.out.println("matches have been loaded successfully");
            System.out.println(listOfMatches);
        }catch (EOFException e){
            System.out.println("file not found");
        }
    }

    public List<Match> randomMatch()throws IOException,ClassNotFoundException{     //this method creates a random match
        ArrayList<Match> matchData =new ArrayList<>();
        matchData.addAll(listOfMatches)  ;

        FootBallClub teamOne = null;
        FootBallClub teamTwo = null;
        Date date = new Date();//gets the current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //format of the date
        String ranDate = formatter.format(date); //assign the format date value to a string
        Random randomMatch = new Random();

        List<FootBallClub> randomList = new ArrayList<FootBallClub>(footBallClubList); //a temporary arraylist that store the details of the footballclublist
        int index = randomMatch.nextInt(randomList.size());
        teamOne = randomList.get(index);//get a random team from  the arraylist
        randomList.remove(index);//remove the randomly choosen  team name from the random list
        int index1 = randomMatch.nextInt(randomList.size());
        teamTwo = randomList.get(index1); //get a random team from the randomList arraylist
        randomList.remove(index1);
        int team1Goals = randomMatch.nextInt(10) + 1; //randomly generate  goals score to team one
        int team2Goals = randomMatch.nextInt(10) + 1;//randomly generate  goals score to team two
        addPlayedMatch(ranDate, teamOne.getNameOfClub(), String.valueOf(team1Goals), teamTwo.getNameOfClub(), String.valueOf(team2Goals));
        save(); //calls the save method to save the created random match
       return listOfMatches;


    }

}