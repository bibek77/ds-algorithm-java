package com.github.bibek77.dsa.onsiteCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bibek
 * A circle is defined by x-axis position, y-axis position, and a radius.
 * A circle group is a collection of circles that overlap.
 * Given a list of circles, figure out if they belong to a single circle group.
 */
public class CircleGroupDfs {
    public static void main(String[] args) {
        List<double[]> circles = new ArrayList<>();
        circles.add(new double[]{0, 0, 2});
        circles.add(new double[]{3, 0, 1});
        circles.add(new double[]{8, 0, 2});

        boolean result = isSingleCircleGroup(circles);
        System.out.println("Circles are a group : " + result);
    }

    public static boolean isSingleCircleGroup(List<double[]> circles) {
        if (circles == null || circles.isEmpty()) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        int size = circles.size();
        for (int i = 0; i < size; i++) {
            if (!visited.contains(i)) {
                dfs(i, circles, visited);
            }
        }
        // If we were able to successfully visit all the nodes then only visited size
        // Will match the circle list size
        // This is wrt condition that no repeated circles in the list.
        return visited.size() == size;
    }

    public static void dfs(int current, List<double[]> circles, Set<Integer> visited) {
        visited.add(current);

        for (int next = 0; next < circles.size(); next++) {
            // Here overlap ensure that the current circle && next circle overlaps,
            // Then only we progress with the bfs
            // else there will be some nodes unvisited
            if (!visited.contains(next) && overlap(circles.get(current), circles.get(next))) {
                dfs(next, circles, visited);
            }
        }
    }

    private static boolean overlap(double[] circle1, double[] circle2) {
        double distance = Math.sqrt(
                Math.pow(circle1[0] - circle2[0], 2) + Math.pow(circle1[1] - circle2[1], 2)
        );
        double sumOfRadii = circle1[2] + circle2[2];
        return distance <= sumOfRadii;
    }
}
