package com.github.bibek77.dsa.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 */
public class NullPointerTest {
    public static void main(String[] args) {
        Map<String, String> child = new HashMap<>();
        child.put("childs", "childValue");
        Map<String, Map> parent = new HashMap<>();
        parent.put("parent", child);
        try {
            System.out.println(checkEqualConstantFirst(parent));
            System.out.println(checkEqualConstantLast(parent));
        } catch (NullPointerException ne) {
            System.out.println("Null Pointer Exception caught + " + ne.getMessage());
            ne.printStackTrace();
        }

    }

    static boolean checkEqualConstantFirst(Map<String, Map> parent) {
        if ("childValue".equalsIgnoreCase(parent.get("parent").get("child").toString()))
            return true;
        return false;
    }

    static boolean checkEqualConstantLast(Map<String, Map> parent) {
        if (parent.get("parent").get("child").toString().equalsIgnoreCase("childValue"))
            return true;
        return false;
    }
}
