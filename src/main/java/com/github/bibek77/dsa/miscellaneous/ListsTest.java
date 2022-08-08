package com.github.bibek77.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bibek
 */
public class ListsTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Blue");
        list.add(25);
        list.add(false);
        System.out.println(list);
        list.forEach(System.out::println);

        List<String> directList = List.of("blue", "red", "green");
        System.out.println(directList);
    }

    public void testSort(){
        int[] arr = {1,2,3,4,5,6};
        Arrays.sort(arr);
    }

}
