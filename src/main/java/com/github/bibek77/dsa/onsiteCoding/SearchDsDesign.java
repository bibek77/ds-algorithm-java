package com.github.bibek77.dsa.onsiteCoding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bibek
 * Design a search data structure to store and display recent searches. If
 * a user just clicks the search bar without typing anything, it should
 * return the N most recent searches. Given a search string it should save
 * the search and also return the N most recent searches
 */
public class SearchDsDesign {
    // Create a ArrayList and fill with searches,
    // restrict the size to n
    // Use it in a round-robin fashion.
    // Any new search will be added at the end,
    // And if size +1 is reached then search would be removed from the head.
    // N search list will be returned.
    // if nothing is typed still n search list will be returned.
    int n;
    List<String> searches;

    SearchDsDesign(int n) {
        this.n = n;
        searches = new ArrayList<>();
    }

    public static void main(String[] args) {

        String search1 = "caterpillar";
        String search2 = "Harry Potter";
        String search3 = "Titanic";
        String search4 = "Lamborghini";
        String search5 = "Data Structures";
        String search6 = "Artificial General Intelligence";
        String search7 = "Flying Mantis";
        String search8 = "Liverpool";


        List<String> searchList = List.of(search1, search2, search3, search4, search5, search6, search7, search8);

        SearchDsDesign searchDsDesign = new SearchDsDesign(5);
        searchDsDesign.searches.addAll(searchList);
        List<String> result = searchDsDesign.performSearch("Artificial General Intelligence");
        result.forEach(System.out::println);

    }

    public List<String> performSearch(String search) {
        // removing from the list of already present.
        if (!search.isEmpty()) {
            searches.remove(search);
            // adding to the search list towards the end.
            searches.add(search);
        }
        return getRecentSearches();
    }

    public List<String> getRecentSearches() {
        // getting the last n searches only
        // sub listing from size - n to size
        return searches.subList(Math.max(0, searches.size() - n), searches.size());
    }
}
