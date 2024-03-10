package com.github.bibek77.dsa.onsiteCoding;

import java.util.*;

/**
 * @author bibek
 * Give the count of managers who has salary less than average salary of direct and indirect employees
 * Example:
 * A->B, A->C, A->D, B->E
 * Salaries
 * A = 50000
 * B = 20000
 * C = 10000
 * D = 10000
 * E = 25000
 * Answer: 1
 * Explanation: A is the manager of direct employees B, C, D
 * And indirect employee E so avg. is 16,250 and B = 20000 < E = 25000 so answer is B
 */
public class AverageSalary {
    int numberOfReports;
    int salary;

    public static void main(String[] args) {
        Map<Character, Integer> salaryMap = new HashMap<>();
        salaryMap.put('A', 50000);
        salaryMap.put('B', 20000);
        salaryMap.put('C', 10000);
        salaryMap.put('D', 10000);
        salaryMap.put('E', 25000);

        char[][] edges = {{'A', 'B'}, {'A', 'C'}, {'A', 'D'}, {'B', 'E'}};
        AverageSalary averageSalary = new AverageSalary();
        int managerCount = averageSalary.underpaidManagers(salaryMap, edges);
        System.out.println(managerCount);

    }

    public int underpaidManagers(Map<Character, Integer> salaryMap, char[][] edges) {
        int result = 0;
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        for (char[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        for (Character manager : adjacencyList.keySet()) {
            numberOfReports = 0;
            salary = 0;
            int managerSalary = salaryMap.get(manager);
            dfs(manager, adjacencyList, salaryMap);
            if (managerSalary < salary / numberOfReports) {
                result++;
            }
//            System.out.println(managerSalary+ ", " + salary/ numberOfReports + ", " + manager);
        }
        return result;
    }

    public void dfs(Character manager, Map<Character, List<Character>> adjMap, Map<Character, Integer> salaryMap) {
        if (!adjMap.containsKey(manager)) return; // reports will not have adjacency list
        for (Character report : adjMap.get(manager)) {
            salary += salaryMap.get(report);
            numberOfReports++;
            dfs(report, adjMap, salaryMap);
        }
    }
}