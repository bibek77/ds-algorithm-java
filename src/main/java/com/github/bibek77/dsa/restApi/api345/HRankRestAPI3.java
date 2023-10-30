package com.github.bibek77.dsa.restApi.api345;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * @author bibek
 */
public class HRankRestAPI3 {
    /**
     * REST API Call to HackerRank Test API
     * Invoke Rest API with paginated response
     * Get Country and Year from the request and print the total goals scored.
     * In the API the country needs to set for both team1 and team2 each to get all matches played.
     * Additional library used is com.google.gson for parsing json.
     * Substitute is to use ScriptManager Javascript eval to create json
     */

    static Gson gson = new Gson();
    public static void main(String[] args) {
        System.out.println(findTotalGoals("Barcelona", 2011));
        System.out.println(findTotalGoals("Chelsea", 2011));
    }

    public static int findTotalGoals(String country, int year) {
        int goalAsHostTeam = 0, goalsAsVisitingTeam = 0;
        String url1 = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%s&team1=%s",year,country);
        String url2 = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%s&team2=%s",year,country);
        try {
            List<Data> data = invokeAPI(url1).data;
            for(Data data1 : data) {
                goalAsHostTeam += Integer.parseInt(data1.team1goals);
            }
        } catch(Exception ex) {}

        try {
            List<Data> data = invokeAPI(url2).data;
            for(Data data1 : data) {
                goalsAsVisitingTeam += Integer.parseInt(data1.team2goals);
            }
        } catch(Exception ex) {}
        return goalAsHostTeam + goalsAsVisitingTeam;
    }

    public static Response invokeAPI(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url1 = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) url1.openConnection();
            String line1 = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line1=br.readLine())!=null) {
                sb.append(line1);
            }
        }catch (Exception ex) {}
        return gson.fromJson(sb.toString(), Response.class);
    }
}
