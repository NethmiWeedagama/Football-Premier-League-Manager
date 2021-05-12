package services;

import Models.FootBallClub;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PremierLeagueManagerTest {
            PremierLeagueManager premierLeagueManagerTest=new PremierLeagueManager();
            FootBallClub  footballclubTest=new FootBallClub("AltonTestClub","Spain",3,2,1,21,26,35,10);


    @Test
    public void addFootBallClub() {
       premierLeagueManagerTest.addFootBallClub(footballclubTest);
    }
    @Test
    public void save()throws IOException,ClassNotFoundException {
        premierLeagueManagerTest.save();
    }


    @Test
    public void displayPrimierLeagueTable()throws IOException,ClassNotFoundException {
       premierLeagueManagerTest.loadFile("footBallClubsFile.ser","matchPlayedFile.ser") ;
       premierLeagueManagerTest.displayPrimierLeagueTable();

    }





}