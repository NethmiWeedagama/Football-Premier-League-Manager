package services;

import Models.FootBallClub;

import java.io.IOException;

public interface LeagueManager {

    void removeFootBallClub(String input);

    void addFootBallClub(FootBallClub footballClub);

    void viewStatistics(String input);

    void save() throws IOException;

    void deleteAll();

    void addPlayedMatch(String dateInput,String input1,String input3,String input2,String input4) ;

    void displayPrimierLeagueTable();

    void loadFile(String clubFile,String matchFile) throws IOException;

    void showAvailableClubs();



}