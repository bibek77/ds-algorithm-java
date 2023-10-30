package com.github.bibek77.dsa.restApi.api2;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.*;

/**
 * @author bibek
 */
public class HRankRestAPI2 {
    /**
     * REST API Call to HackerRank Test API
     * Invoke Rest API with non paginated response, pagination not required as country is passed
     * And find the capital of country from the response and return.
     * Return "-1" is capital is not present.
     * Additional library used is com.google.gson for parsing json.
     * Substitute is to use ScriptManager Javascript eval to create json
     */
    static Gson gson = new Gson();
    public static void main(String[] args) {
        System.out.println(findCapital("India"));
        System.out.println(findCapital("Hawai"));
    }

    public static String findCapital(String countryName) {
        String capital = "";
        try {
            capital = invokeAPI(countryName).data.get(0).capital;
        } catch (Exception ex) {
            // Message can be printed as country/capital is not found
        }
        if(capital!=null && !capital.equals(""))
            return capital;
        return "-1";
    }

    public static Response invokeAPI(String countryName) {

        StringBuilder sb = new StringBuilder();
        String urlPath = "https://jsonmock.hackerrank.com/api/countries?name=%s";
        try {
            URL url = new URL(String.format(urlPath, countryName));
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = br.readLine())!=null) {
                sb.append(line);
            }
            con.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return gson.fromJson(sb.toString(), Response.class);
    }
}
