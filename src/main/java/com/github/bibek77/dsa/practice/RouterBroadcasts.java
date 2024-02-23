package com.github.bibek77.dsa.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bibek
 */
public class RouterBroadcasts {

    public static class Router {
        String name;
        int x, y;

        public Router(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object obj) {
            Router router = (Router) obj;
            return name.equals(router.name) && x == router.x && y == router.y;
        }

    } // end of router class

    // Distance calculation between 2 coordinates on a graph formula sqrt((ax-bx)^2 + (ay - by)^2)
    public double distance(Router a, Router b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    // If Distance between 2 routers is in range 10.0 then true.
    public boolean isInRange(Router fromRouter, Router toRouter) {
        return distance(fromRouter, toRouter) <= 10.0;
    }

    public boolean broadcastMessage(Router start, Router target, List<Router> routers) {

        Queue<Router> queue = new LinkedList<>();
        Set<String> shutdownRouter = new HashSet<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Router currRouter = queue.poll();
            if (currRouter.equals(target)) return true;
            if (shutdownRouter.contains(currRouter.name)) continue;

            List<Router> nextRouters = routers.stream()
                    .filter(nextRouter -> !nextRouter.equals(currRouter) && !shutdownRouter.contains(nextRouter.name) && isInRange(currRouter, nextRouter))
                    .collect(Collectors.toList());

// queue.addAll(nextRouters);
            queue.addAll(nearestRouters(currRouter, nextRouters)); // add only the nearest routers
            shutdownRouter.add(currRouter.name);
        }
        return false;
    }

    public List<Router> nearestRouters(Router currRouter, List<Router> nextRouters) {

        Map<Double, List<Router>> minDistMap = new HashMap<>();
        double minDist = 100.0; // As next routers distance is at most 10.0
        for (Router nextRouter : nextRouters) {

            double dist = distance(currRouter, nextRouter);
            if (minDist >= dist) {
                minDist = dist;
                List<Router> nearList = minDistMap.getOrDefault(minDist, new ArrayList<>());
                nearList.add(nextRouter);
                minDistMap.putIfAbsent(minDist, nearList);
            }
        }
        return minDistMap.getOrDefault(minDist, new ArrayList<>());
    }

    public static void main(String[] args) {
        RouterBroadcasts obj = new RouterBroadcasts();
        Router a = new Router("a", 0, 0);
        Router b = new Router("b", 0, 8);
        Router c = new Router("c", 0, 17);
        Router d = new Router("d", 11, 0);
        Router e = new Router("e", 4, 0);
        Router f = new Router("f", 0, 4);
        Router g = new Router("f", 6, 8);
        System.out.println(obj.broadcastMessage(a, b, Arrays.asList(a, b, c, d)));
        System.out.println(obj.broadcastMessage(a, d, Arrays.asList(a, b, c, d)));

    }

}

