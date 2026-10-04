package com.github.bibek77.dsa.restApi.api6;

import com.github.bibek77.dsa.restApi.api2.Response;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bibek
 * REST API Call to HackerRank Test API
 * Invoke Rest API with non paginated response, pagination not required as country is passed
 * And find the calling code of country from the response and return.
 * Calling code is an array, hence return the highest index value.
 * Return "-1" is calling code is not present.
 * Additional library used is com.google.gson for parsing json.
 * Substitute is to use ScriptManager Javascript eval to create json
 */
public class HRankRestAPI6 {
    static Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println(findCallingNumber("India", "9090123456"));
        System.out.println(findCallingNumber("Afghanistan", "1234569090"));
        System.out.println(findCallingNumber("Wakanda", "9191090909"));
    }

    public static String findCallingNumber(String countryName, String phoneNumber) {
        List<String> callingCodes = new ArrayList<>();
        String code = "-1";
        try {
            callingCodes = invokeAPI(countryName).data.get(0).callingCodes;
            if (!callingCodes.isEmpty()) {
                code = callingCodes.get(callingCodes.size() - 1);
            }
        } catch (Exception ex) {
            // Message can be printed as country/capital is not found
        }
        if (!code.equals("-1")) return "+".concat(code).concat(" ").concat(phoneNumber);
        return code;
    }

    public static Response invokeAPI(String countryName) {

        StringBuilder sb = new StringBuilder();
        countryName = countryName.replaceAll(" ", "+");
        String urlPath = "https://jsonmock.hackerrank.com/api/countries?name=%s";
        try {
            URL url = new URL(String.format(urlPath, countryName));
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            con.disconnect();
        } catch (Exception ex) {
            System.out.println("Country is not found, hence Exception returned.");
//            ex.printStackTrace();
        }
        return gson.fromJson(sb.toString(), Response.class);
    }

    public static class Response {
        List<Data> data;
    }

    public static class Data {
        String name;
        List<String> callingCodes;
    }
}