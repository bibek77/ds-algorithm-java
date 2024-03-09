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
    public static void main(String[] args) {
        Map<Character, Integer> salaryMap = new HashMap<>();
        salaryMap.put('A', 50000);
        salaryMap.put('B', 20000);
        salaryMap.put('C', 10000);
        salaryMap.put('D', 10000);
        salaryMap.put('E', 25000);

        char[][] edges = {{'A', 'B'}, {'A', 'C'}, {'A', 'D'}, {'B', 'E'}};
        AverageSalary averageSalary = new AverageSalary();
        int managerCount = averageSalary.managersWithLessAvgSalaryCount(salaryMap, edges);
        System.out.println(managerCount);

    }

    public int managersWithLessAvgSalaryCount(Map<Character, Integer> salaryMap, char[][] edges) {
        int result = 0;
        // Find inDegree 0
        // Add to the queue as they are managers
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int n = salaryMap.size();
        int[] inDegree = new int[n];
        for (char[] edge : edges) {
            adjMap.computeIfAbsent(edge[0] - 'A', k -> new ArrayList<>()).add(edge[1] - 'A');
            inDegree[edge[1] - 'A']++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int managerSalary = salaryMap.get((char) (currentNode + 'A'));
            int averageReportSalary = 0;
            int numberOfReport = 0;
            if (!adjMap.containsKey(currentNode)) continue; // in case these are not managers
            // They will not have an adjacency Map of directed towards any employee
            for (int adjNode : adjMap.get(currentNode)) {
                averageReportSalary += salaryMap.get((char) (adjNode + 'A'));
                numberOfReport++;
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
            averageReportSalary /= numberOfReport;
            if (managerSalary < averageReportSalary)
                result++;
        }
        return result;
    }
}
