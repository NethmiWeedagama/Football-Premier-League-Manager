//"I confirm that I understand what plagiarism /
//        collusion / contract cheating is and have read and
//        understood the section on Assessment Offences in the
//        Essential Information for Students. The work that I
//        have submitted is entirely my own. Any work from
//        other authors is duly referenced and acknowledged."
//Name:Nethmi sachindi weedagama
//UOW ID:W1761927

package Models;


import services.PremierLeagueManager;

import java.io.IOException;
import java.util.Scanner;

public class Main  {
    static  Scanner userChoice = new Scanner(System.in);
    private static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    static int numOfWins = 0;
    static int numOfDraws = 0;
    static int numOfDefeats = 0;
    static int numOfGoalsReceived = 0;
    static int numOfGoalsScored = 0;
    static int numOfPoints = 0;
    static int numOfMatchesPlayed = 0;
    public static void main(String[] args) throws IOException {


        premierLeagueManager.loadFile("footBallClubsFile.ser","matchPlayedFile.ser");  //automatically loads the file
        String menu = null;

        do {
            System.out.println();

            // menu to choose the options
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("--                           WELCOME TO PREMIER LEAGUE MANAGER                                      --");
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("| A : Press A to  Create a new football club and add it in the premier league                        |");
            System.out.println("| D : Press D to Delete (relegate) an existing club from the premier league.                         |");
            System.out.println("| V : Press V to Display the various statistics for a selected club.                                 |");
            System.out.println("| M : Press M to Add a played match with its score and its date                                      |");
            System.out.println("| P : Press P to Display the Premier League Table,                                                   |");
            System.out.println("| X : Press X to Exit                                                                                |");
            System.out.println("| S : Press S to Saving in a file of all the information entered by the user                         |");
            System.out.println("| L : Press L to Loading the file of all the information entered by the user                         |");
            System.out.println("| W : Sort the list (table) of all the teams and their statistics in  the GUI                        |");
            System.out.println("| Z : Display the   GUI                                                                              |");
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("|                                   ENTER YOUR CHOICE                                                |");
            System.out.println("------------------------------------------------------------------------------------------------------");
            menu = userChoice.next().toUpperCase();
            switch (menu) {

                case "A": {
                    addFootBallClub();//call the addFootBallClub method

                    break;
                }
                case "D": {
                    removeFootballClubs();//call the removeFootballClubs method

                    break;
                }
                case "V": {
                    viewStatistics();//call the viewStatistics method

                    break;
                }
                case "M": {
                    addMatch();//call the addMatch method

                    break;
                }
                case "S": {
                    premierLeagueManager.save();//call the save method
                    break;
                }
                case "P": {
                    displayLeagueTable();//call the displayLeagueTable method

                    break;
                }

                case "L": {
                    premierLeagueManager.loadFile("footBallClubsFile.ser","matchPlayedFile.ser");//call the loadFile method
                    break;
                }


                case "Z": {

                   System.out.println("Displaying the GUI");
                   String connect="http://localhost:4200/";
                   java.awt.Desktop.getDesktop().browse(java.net.URI.create(connect));
                    break;
                }
                case "W": {
                    premierLeagueManager.deleteAll();//call the addFootBallClub method

                    break;
                }

                case "X": {
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Enter a valid Input");

                    break;
                }
            }

        } while (menu != "X");


    }



    public static void addFootBallClub() {
        // receiving user input
        FootBallClub footballClub=null;
        System.out.println("Enter the Name of the Football Club:");
        String nameOfClub = userChoice.next();
        System.out.println("Enter the Location of the Football club :");
        String locationOfClub = userChoice.next();

        footballClub = new FootBallClub(nameOfClub, locationOfClub, numOfWins, numOfDraws, numOfDefeats, numOfGoalsReceived, numOfGoalsScored, numOfPoints, numOfMatchesPlayed);

        premierLeagueManager.addFootBallClub(footballClub);
    }
    public static void viewStatistics(){
        premierLeagueManager.showAvailableClubs();  //display the available football clubs
        System.out.println("Enter club name to view the statistics: ");
        String input = userChoice.next();
        premierLeagueManager.viewStatistics(input);

    }


    private static void displayLeagueTable(){

        premierLeagueManager.displayPrimierLeagueTable() ;
    }
    public static void removeFootballClubs() {
        premierLeagueManager.showAvailableClubs();//display the available football clubs in the premier league
        System.out.println("Enter club name to remove from the premier league: ");
        String input = userChoice.next();
        premierLeagueManager.removeFootBallClub(input);
    }
    public static void addMatch(){
        System.out.println("Enter the Date in the format dd/MM/yyyy :");
        String dateInput = userChoice.next();
        System.out.println("Enter first Team: ");
        String input1 = userChoice.next();
        System.out.println("Enter first team goals: ");
        String input3 = userChoice.next();
        System.out.println("Enter second Team: ");
        String input2 = userChoice.next();
        System.out.println("Enter second team goals: ");
        String input4= userChoice.next();
        premierLeagueManager.addPlayedMatch(dateInput,input1,input3,input2,input4);
    }

}
