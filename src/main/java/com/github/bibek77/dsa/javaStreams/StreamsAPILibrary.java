package com.github.bibek77.dsa.javaStreams;

import com.github.bibek77.dsa.javaStreams.refClass.Book;
import com.github.bibek77.dsa.javaStreams.refClass.Category;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author bibek
 */
public class StreamsAPILibrary {

    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book(1, "Java Book 1", Category.PROGRAMMING, 4.8, 205.5),
                new Book(2, "History Book 1", Category.HISTORY, 4.2, 140.8),
                new Book(3, "Science Book 1", Category.SCIENCE, 4.3, 150),
                new Book(4, "Novel 1", Category.FICTION, 4.7, 122),
                new Book(5, "Math Book 1", Category.PROGRAMMING, 4.7, 290.7),
                new Book(6, "Java Book 2", Category.PROGRAMMING, 4.6, 300),
                new Book(7, "History Book 2", Category.HISTORY, 4.2, 20.90),
                new Book(8, "Science Book 2", Category.SCIENCE, 4.4, 60.5),
                new Book(9, "Novel 2", Category.FICTION, 4.9, 100),
                new Book(10, "Math Book 2", Category.PROGRAMMING, 4.3, 120),
                new Book(5, "Math Book 1", Category.PROGRAMMING, 4.7, 130.8),
                new Book(6, "Java Book 2", Category.PROGRAMMING, 4.6, 165.90)
        );

        Map<Category, List<Book>> booksByCategory =
                books.stream().filter(book -> book.getRating() >= 4.5)
                        .collect(groupingBy(Book::getCategory));


        //Slicing the stream.
        // All operations
        List<String> books1 = books.stream().filter(d -> d.getRating() >= 4.6)
                .distinct()
                .limit(2)
                .map(d -> d.getTitle())
//                                .forEach(System.out::println);
                .collect(Collectors.toList());

        books1.stream().forEach(System.out::println);

        System.out.println("------------------------");

        //Matching Operations
        //AnyMatch

        boolean anyMatch = books.stream().anyMatch(d -> d.getRating() <= 4.5);
        System.out.println("Any Match : " + anyMatch);

        boolean allMatch = books.stream().allMatch(d -> d.getRating() <= 7);
        System.out.println("All Match : " + allMatch);

        boolean noneMatch = books.stream().noneMatch(d -> d.getRating() <= 2.5);
        System.out.println("None Match : " + noneMatch);

        //Find Operations

        Optional<Book> opt = books.stream().filter(d -> d.getRating() < 5.6).findFirst();
        opt.stream().forEach(System.out::println);

        //Reduction operations

        String[] bookRates = {"A", "B", "C", "X"};

        //Normal Reduce
        books.stream().reduce((b1, b2) -> b1.getRating() > b2.getRating() ? b1 : b2)
                .ifPresent(b -> System.out.println("Highest Rating : " + b.getRating()));

        //Overloaded Reduce Identity / Accumulator / Combiner
        String sum = Arrays.stream(bookRates).reduce("", (s1, s2) -> s1 + s2);

        //If parameters are of different types then this format is required else combiner is not required.
        //Below case, it is different, string and string builder
        // first identity, then accumulator sb + string, then a combiner sb + sb
        StringBuilder sum2 = Arrays.stream(bookRates).reduce(new StringBuilder(), (sb1, s) -> sb1.append(s)
                , (sb2, sb3) -> sb2.append(sb3));
        System.out.println(sum);
        System.out.println(sum2.toString());
        // Reduce does not work with parallel stream as it is immutable
        // Hence collect works better in that case.

        StringBuilder sum3 = Arrays.stream(bookRates).parallel().collect(() -> new StringBuilder(), (sb1, s) -> sb1.append(s)
                , (sb2, sb3) -> sb2.append(sb3));
        System.out.println("Collector output : " + sum3);

        //Tweaking Reduce method to do the same with parallel.
        //By creating a StringBuilder container everytime it accumulates, but its inefficient.
        StringBuilder sum4 = Arrays.stream(bookRates).parallel().reduce(new StringBuilder()
                , (sb1, s) -> new StringBuilder(sb1).append(s), (sb2, sb3) -> sb2.append(sb3));
        System.out.println("Reduce tweak : " + sum4);

        // Using Collector class for joining.
        String sum5 = Arrays.stream(bookRates).parallel().collect(Collectors.joining());
        System.out.println("Collectors join : " + sum5);

        // Collectors
        List<Book> bookList = books.stream().filter(book -> book.getRating() > 4.8)
                .distinct()
//                .collect(ArrayList::new,
//                        ArrayList::add,
//                        ArrayList::addAll)
//                        .collect(() -> new ArrayList<>(),
//                                (a1, t) -> a1.add(t),
//                                (a2, a3) -> a2.addAll(a3));
                .collect(Collectors.toList());
        bookList.forEach(System.out::println);

        Set<Book> set = books.stream().filter(book -> book.getRating() > 4.3)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        // Collectors to Map
        Map<Integer, Book> map = books.stream()
//                .collect(Collectors.toMap(b -> b.getId(), b -> b)); // Direct if no duplicate
                .collect(Collectors.toMap(b -> b.getId(), b -> b, (b1, b2) -> b1.getRating() < b2.getRating() ? b1 : b2));

        for (Map.Entry<Integer, Book> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());

        }

        // Collectors grouping

        Map<Double, List<Book>> map2 = books.stream()
                .collect(Collectors.groupingBy(Book::getRating));

        for (Map.Entry<Double, List<Book>> entry : map2.entrySet()) {
            System.out.println("Key : " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println(book);
            }
        }

        // Overloading Default List as Set

        Map<Double, Set<Book>> map3 = books.stream()
                .collect(Collectors.groupingBy(Book::getRating, toSet()));

        for (Map.Entry<Double, Set<Book>> entry : map3.entrySet()) {
            System.out.println("Key : " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println(book);
            }
        }

        // Collectors utils - sum, average, min
        Map<Double, Double> map4 = books.stream()
                .collect(Collectors.groupingBy(Book::getRating, Collectors.averagingDouble(Book::getPrice)));

        for (Map.Entry<Double, Double> entry : map4.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

        // Grouping Streams
        // Use groupingBy for group, and internally define mapping, filtering, reducing, etc. if needed
        Map<Category, List<String>> bookCategory = books.stream()
                .collect(groupingBy(Book::getCategory, Collectors.mapping(Book::getTitle, toList())));
        for (Map.Entry<Category, List<String>> entry : bookCategory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
