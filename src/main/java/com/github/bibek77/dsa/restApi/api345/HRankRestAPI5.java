package com.github.bibek77.dsa.restApi.api345;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.*;

/**
 * @author bibek
 */
public class HRankRestAPI5 {
    /**
     * REST API Call to HackerRank Test API
     * Invoke Rest API with paginated response
     * And calculate Number of Drawn Matches for the given year.
     * The maximum goals scored in any year is 10.
     * Additional library used is com.google.gson for parsing json.
     * Substitute is to use ScriptManager Javascript eval to create json
     */

    static Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println("Number of Draws: " + findDrawsInYear(2011));
    }

    public static int findDrawsInYear(int year) {
        int draws = 0;
        for (int i = 0; i <= 10; i++) {
            String url = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%s&team1goals=%s&team2goals=%s", year, i, i);
            Response response = invokeAPI(url);
            draws += response.total;
        }
        return draws;
    }

    public static Response invokeAPI(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url1 = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) url1.openConnection();
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception ex) {
        }
        return gson.fromJson(sb.toString(), Response.class);
    }
}
