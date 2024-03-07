package com.github.bibek77.dsa.onsiteCoding;

import java.util.*;

/**
 * @author bibek
 * Given on-call rotation schedule for multiple people by: their name, start time and end time of the rotation:
 * <p>
 * Abby 1 10
 * Ben 5 7
 * Carla 6 12
 * David 15 17
 * <p>
 * Your goal is to return rotation table without overlapping periods representing who is on call during that time.
 * Return "Start time", "End time" and list of on-call people:
 * <p>
 * 1 5 Abby
 * 5 6 Abby, Ben
 * 6 7 Abby, Ben, Carla
 * 7 10 Abby, Carla
 * 10 12 Carla
 * 15 17 David
 */
public class OverlappingPeriods {

    public static void main(String[] args) {

        List<String[]> scheduleList = new ArrayList<>();
        scheduleList.add(new String[]{"Abby", "1", "10"});
        scheduleList.add(new String[]{"Ben", "5", "7"});
        scheduleList.add(new String[]{"Carla", "6", "12"});
        scheduleList.add(new String[]{"David", "15", "17"});

        List<String[]> result = splitPerTime(scheduleList);

        for (String[] events : result) {
            System.out.println("Start Time : " + events[0] + " , End Time : " + events[1] + " , Name : " + events[2]);
        }

    }

    public static List<String[]> splitPerTime(List<String[]> scheduleList) {
        List<String[]> result = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();

        for (String[] schedule : scheduleList) {
            events.add(new Event(schedule[0], Integer.parseInt(schedule[1]), true));
            events.add(new Event(schedule[0], Integer.parseInt(schedule[2]), false));
        }

        events.sort((event1, event2) -> {
            int timeComparison = Integer.compare(event1.time, event2.time);
            if (timeComparison != 0) {
                return timeComparison; // Sort by time in ascending order
            } else {
                return Boolean.compare(event1.isStart, event2.isStart);
                // If time is the same, sort by isStart in ascending order
            }
        });

        int start = -1;
        int end = -1;
        List<String> names = new ArrayList<>();

        for (Event event : events) {
            start = end;
            end = event.time;

            if (!names.isEmpty() && start != -1 && start != end) {
                result.add(new String[]{String.valueOf(start), String.valueOf(end), names.toString().replace("[", "").replace("]", "")});
            }

            if (!event.isStart) {
                names.remove(event.name);
            } else {
                names.add(event.name);
            }
        }
        return result;
    }

    static class Event {
        String name;
        int time;
        boolean isStart;

        Event(String name, int time, boolean isStart) {
            this.name = name;
            this.time = time;
            this.isStart = isStart;
        }
    }
}
