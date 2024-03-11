package com.github.bibek77.dsa.onsiteCoding;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 * // Phone Screen //
 * template -> "Hi %username%, thanks for using %product name%. Regards, %signature%"
 * <p>
 * data -> {
 * "username" : "bibek",
 * "product name" : "%company name% Search",
 * "signature" : "Your friends at %company name%",
 * "company name" : "Google"
 * }
 */
public class EmailTemplate {

    public static void main(String[] args) {

        Map<String, String> data = new HashMap<>();
        data.put("username", "bibek");
        data.put("product name", "%company name% Search");
        data.put("signature", "Your friends at %company name%");
        data.put("company name", "Google");

        String template = "Hi %username%, thanks for using %product name%. Regards, %signature%";
        EmailTemplate emailTemplate = new EmailTemplate();
        System.out.println(emailTemplate.expandTemplate(template, data));


    }

    public String expandTemplate(String template, Map<String, String> data) {

        char[] charTemplate = template.toCharArray();
        int n = template.length();
        String result = template;
        int i = 0, j = 0;

        for (int k = 0; k < n; k++) {
            if (charTemplate[k] == '%' && i == 0) {
                i = k; // first percentage
            } else if (charTemplate[k] == '%') {
                j = k; // second percentage
            }
            if (i != 0 && j != 0) {
                String placeholder = template.substring(i + 1, j);
                String placeholderValue = data.get(placeholder);
                while (placeholderValue.contains("%")) {
                    int plcIndex = result.indexOf("%" + placeholder + "%");
                    result = result.substring(0, plcIndex) + placeholderValue + result.substring(plcIndex + placeholder.length() + 2);
                    i = placeholderValue.indexOf('%');
                    j = placeholderValue.lastIndexOf('%');
                    placeholder = placeholderValue.substring(i + 1, j); // to remove the i && j position too as they are %
                    placeholderValue = data.get(placeholder);
                }
                int plcIndex = result.indexOf("%" + placeholder + "%");
                // we are adding +2 , as placeholder length is missing beginning and ending percentage values
                result = result.substring(0, plcIndex) + placeholderValue + result.substring(plcIndex + placeholder.length() + 2);
                i = 0;
                j = 0;
            } // i!=j && j!=j closure
        } // outer for loop
        return result;
    }
}
