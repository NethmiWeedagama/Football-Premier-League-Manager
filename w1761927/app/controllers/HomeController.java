package controllers;


import Models.FootBallClub;
import Models.Match;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.LeagueManager;
import services.PremierLeagueManager;

import java.util.List;




public class HomeController extends Controller {

    private static final LeagueManager leagueManagerList = PremierLeagueManager.getInstance();




    public Result getMatches() {
        JsonNode jsonNode;
        try {
            List<Match> matches = (((PremierLeagueManager)leagueManagerList).getMatchList());
          //  System.out.println(matches);
            jsonNode = Json.toJson(matches);
            System.out.println(jsonNode);
            return created(jsonNode);
        }catch (Exception e) {
            return null;
        }
    }
    public Result getFootBallClubs() {
        JsonNode jsonNode1;
        try {
            List<FootBallClub> footballClubs = (((PremierLeagueManager)leagueManagerList).getFootBallClubList());
            System.out.println(footballClubs);
            jsonNode1 = Json.toJson(footballClubs);
            System.out.println(jsonNode1);
            return created(jsonNode1);
        }catch (Exception e) {
            return null;
        }
    }
    public Result getSortByPoints() {
        JsonNode jsonNode2;
        try {
            List<FootBallClub> footballClubs1 = (((PremierLeagueManager)leagueManagerList).sortTableFootballClubPoints());
            System.out.println(footballClubs1);
            jsonNode2 = Json.toJson(footballClubs1);
            System.out.println(jsonNode2);
            return created(jsonNode2);
        }catch (Exception e) {
            return null;
        }
    }
    public Result getSortByWins() {
        JsonNode jsonNode3;
        try {
            List<FootBallClub> footballClubs2 = (((PremierLeagueManager)leagueManagerList).sortTableFootballClubWin());
            System.out.println(footballClubs2);
            jsonNode3 = Json.toJson(footballClubs2);
            System.out.println(jsonNode3);
            return created(jsonNode3);
        }catch (Exception e) {
            return null;
        }
    }
    public Result getSortByGoals() {
        JsonNode jsonNode4;
        try {
            List<FootBallClub> footballClubs3 = (((PremierLeagueManager)leagueManagerList).sortTableFootballClubGoals());
            System.out.println(footballClubs3);
            jsonNode4= Json.toJson(footballClubs3);
            System.out.println(jsonNode4);
            return created(jsonNode4);
        }catch (Exception e) {
            return null;
        }
    }

    public Result getMatchSortByDate() {
        JsonNode jsonNode5;
        try {
            List<Match>matchDetails = (((PremierLeagueManager)leagueManagerList).sortTableMatchDate());
            System.out.println(matchDetails);
            jsonNode5= Json.toJson(matchDetails);
            System.out.println(jsonNode5);
            return created(jsonNode5);
        }catch (Exception e) {
            return null;
        }
    }
    public Result getRandomMatchPlayed() {
        JsonNode jsonNode6;
        try {
            List<Match>matchDetails = (((PremierLeagueManager)leagueManagerList).randomMatch());
            System.out.println(matchDetails);
            jsonNode6= Json.toJson(matchDetails);
            System.out.println(jsonNode6);
            return created(jsonNode6);
        }catch (Exception e) {
            return null;
        }


    }
    public Result getsearchMatches(String filterDate) {
        JsonNode jsonNode8;
        try {
            List<Match> matchesPlayed = (((PremierLeagueManager)leagueManagerList).searchTableMatch(filterDate));
            System.out.println(matchesPlayed);
            jsonNode8 = Json.toJson(matchesPlayed);
            System.out.println(jsonNode8);
            return created(jsonNode8);
        }catch (Exception e) {
            return null;
        }
    }
//    public Result appSummary() {
//        JsonNode jsonNode = Json.toJson(new AppSummary("Java Play Angular Seed"));
//        return ok(jsonNode).as("application/json");
//    }
//
//    public Result postTest() {
//        JsonNode jsonNode = Json.toJson(new AppSummary("Post Request Test => Data Sending Success"));
//        return ok(jsonNode).as("application/json");
//    }
}

