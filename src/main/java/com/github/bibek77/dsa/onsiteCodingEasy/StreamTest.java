package com.github.bibek77.dsa.onsiteCodingEasy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bibek
 * <p>
 * Class Persons
 * 2 Fields - Person Name , Person - Age
 * List of Person - Input
 * Based on Age : 20 ,
 */
public class StreamTest {

    public static void main(String[] args) {

        Person person1 = new Person("Jim", 26);
        Person person2 = new Person("Jerry", 24);
        Person person3 = new Person("Jack", 24);
        Person person4 = new Person("Tom", 25);
        Person person5 = new Person("Max", 25);
        Person person6 = new Person("Fred", 25);

        List<Person> input = Arrays.asList(person1, person2, person3, person4, person5, person6);
        Map<Integer, List<String>> result = getName(input);
        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        List<Job> jobs = Arrays.asList(
                new Job(1, "t1", "in-progress"),
                new Job(1, "t2", "waiting"),
                new Job(2, "t3", "completed"),
                new Job(2, "t4", "failed"),
                new Job(3, "t5", "in-progress")
        );

        Map<Integer, String> jobStatus = sortJobs(jobs);

        for (Map.Entry<Integer, String> entry : jobStatus.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }

    public static Map<Integer, List<String>> getName(List<Person> personList) {

        Map<Integer, List<String>> result = new HashMap<>();

        // Without functional programming
//        for (Person person : personList) {
//            int age = person.age;
//            if (!result.containsKey(age)) {
//                result.put(age, new ArrayList<>());
//            }
//            result.get(age).add(person.personName);
//        }

        result = personList.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getPersonName, Collectors.toList())));

        // Sorted manner
//        result = personList.stream()
//                .collect(Collectors.groupingBy(Person::getAge,
//                        TreeMap::new,
//                        Collectors.mapping(Person::getPersonName, Collectors.toList())));

        return result;
    }

    public static class Person {

        String personName;
        int age;

        Person(String personName, int age) {
            this.personName = personName;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getPersonName() {
            return personName;
        }
    }

    public static Map<Integer, String> sortJobs(List<Job> jobs) {

        //3 columns - jobId, timestamp, status
//               1,     t1,     in-progress
//               1,     t2,     waiting
//.......
// for each Job - latest stamp - what is the status.

        Map<Integer, String> result = jobs.stream().collect(
                Collectors.toMap(
                        Job::getJobId,
                        Job::getStatus,
                        (existing, replacement) -> existing.compareTo(replacement) > 0 ? existing : replacement
                )
        );

        // collectors map has first key, then value, then merge function,
        // If multiple key is found  then, merge function decides which value  will win.
        // here compareTo lexicographically compares both string , if first string is smaller then returns -ve, greater than +ve, else 0;

        return result;
    }


    static class Job {
        private int jobId;
        private String timestamp;
        private String status;

        public Job(int jobId, String timestamp, String status) {
            this.jobId = jobId;
            this.timestamp = timestamp;
            this.status = status;
        }

        public int getJobId() {
            return jobId;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getStatus() {
            return status;
        }


    }
}

//3 columns - jobId, timestamp, status
//               1,     t1,     in-progress
//               1,     t2,     waiting
//.......
// for each Job - latest stamp - what is the status.

//Using SQL

//SELECT j1.jobId, j1.timestamp, j1.status
//FROM JOBS j1
//INNER JOIN (
//        SELECT jobId, MAX(timestamp) AS latest_timestamp
//FROM JOBS
//GROUP BY jobId
//) j2 ON j1.jobId = j2.jobId AND j1.timestamp = j2.latest_timestamp;