package com.github.bibek77.dsa.restApi.api345;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author bibek
 */
public class HRankRestAPI4 {

    static Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println("Total Goals by winning team : "+ findGoalsScored("UEFA Champions League", 2011));
        System.out.println("Total Goals by winning team : "+ findGoalsScored("English Premier League", 2014));
        System.out.println("Total Goals by winning team : "+ findGoalsScored("La Liga", 2012));
    }

    public static int findGoalsScored(String competition, int year) {

        String winningCountry = "";
        int totalGoals = 0;
        try {
            competition = URLEncoder.encode(competition, StandardCharsets.UTF_8.toString());
            String url1WinningCountry = String.format("https://jsonmock.hackerrank.com/api/football_competitions?year=%s&name=%s", year, competition);
            Response checkWinCountry = invokeAPI(url1WinningCountry);
            winningCountry = checkWinCountry.data.get(0).winner;
            winningCountry = URLEncoder.encode(winningCountry, StandardCharsets.UTF_8.toString());

            String urlGoalsByCountry = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%s&team1=%s&competition=%s", year, winningCountry, competition);
            Response goalsByTeam1Response = invokeAPI(urlGoalsByCountry);
            for (Data data : goalsByTeam1Response.data) {
                totalGoals += Integer.parseInt(data.team1goals);
            }

            int total_pages = goalsByTeam1Response.total_pages;
            int i=1;
            while (i++ <= total_pages) {
                Response goalsByTeam1ResponseNextPages = invokeAPI(urlGoalsByCountry+"&page="+i);
                for (Data data : goalsByTeam1ResponseNextPages.data) {
                    totalGoals += Integer.parseInt(data.team1goals);
                }
            }

            String urlGoalsByVisitCountry = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%s&team2=%s&competition=%s", year, winningCountry, competition);
            Response goalsByTeam2Response = invokeAPI(urlGoalsByVisitCountry);
            for (Data data : goalsByTeam2Response.data) {
                totalGoals += Integer.parseInt(data.team2goals);
            }

            total_pages = goalsByTeam2Response.total_pages;
            i=1;
            while (i++ <= total_pages) {
                Response goalsByTeam2ResponseNextPages = invokeAPI(urlGoalsByVisitCountry+"&page="+i);
                for (Data data : goalsByTeam2ResponseNextPages.data) {
                    totalGoals += Integer.parseInt(data.team2goals);
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return totalGoals;
    }

    public static Response invokeAPI(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url1 = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) url1.openConnection();
            String line="";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while((line = br.readLine())!=null) {
                sb.append(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return gson.fromJson(sb.toString(), Response.class);
    }
}
