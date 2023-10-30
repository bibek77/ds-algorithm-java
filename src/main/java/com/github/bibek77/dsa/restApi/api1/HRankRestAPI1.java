package com.github.bibek77.dsa.restApi.api1;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.*;

/**
 * @author bibek
 */
public class HRankRestAPI1 {
    /**
     * REST API Call to HackerRank Test API
     * Invoke Rest API with paginated response
     * And calculate average pulse for given doctor.id, diagnosis.name from response.
     * Additional library used is com.google.gson for parsing json.
     * Substitute is to use ScriptManager Javascript eval to create json
     */

    static Gson gson = new Gson();
    public static void main(String[] args) {
        System.out.println(findPulseAverage(2, "Pulmonary embolism"));
        System.out.println(findPulseAverage(4, "Common Cold"));
    }

    public static int findPulseAverage(int doctorId, String diagnosis) {
        Stream<Response> streamResponse = invokeAPI("https://jsonmock.hackerrank.com/api/medical_records?page=%s");

        int totalPulse = 0;
        int count = 0;
        for(Response response : streamResponse.toList()) {
            List<Data> data = response.data;
            for (Data data1 : data) {
                if (data1.diagnosis.name.equals(diagnosis) && data1.doctor.id == doctorId) {
                    totalPulse += data1.vitals.pulse;
                    count++;
                }
            }
        }
        if (count > 0) {
            return totalPulse / count;
        } else {
            return 0;
        }
    }

    public static Stream<Response> invokeAPI(String url) {
        Response response = invoke(String.format(url, 1));
        Stream<Response> responseStream = Stream.of(response);

        for(int i=2; i<=response.total_pages; i++) {
            Response nextResponse = invoke(String.format(url, i));
            responseStream = Stream.concat(responseStream, Stream.of(response));
        }
        return responseStream;
    }

    public static Response invoke(String url) {

        StringBuilder sb = new StringBuilder();
        try {
            URL url1 = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) url1.openConnection();
//            con.setRequestMethod("GET");
//            con.getResponseCode();
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            if ((line = br.readLine()) != null) {
                sb.append(line);
            }
            con.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        System.out.println(sb.toString());
        return gson.fromJson(sb.toString(), Response.class);
    }
}

//public class Response {
//    int total_pages;
//    List<Data> data;
//}
//
//public class Data {
//    Diagnosis diagnosis;
//    Doctor doctor;
//    Vitals vitals;
//}
//
//public class Diagnosis {
//    String name;
//}
//
//public class Doctor {
//    int id;
//}
//
//public class Vitals {
//    int pulse;
//}
//
