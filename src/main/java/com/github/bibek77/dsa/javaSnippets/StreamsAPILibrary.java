package com.github.bibek77.dsa.javaSnippets;

import com.github.bibek77.dsa.javaSnippets.refClass.Book;
import com.github.bibek77.dsa.javaSnippets.refClass.Category;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author bibek
 */
public class StreamsAPILibrary {

    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book(1, "Java Book 1", Category.PROGRAMMING, 4.8),
                new Book(2, "History Book 1", Category.HISTORY, 4.2),
                new Book(3, "Science Book 1", Category.SCIENCE, 4.5),
                new Book(4, "Novel 1", Category.FICTION, 4.7),
                new Book(5, "Math Book 1", Category.PROGRAMMING, 4.7),
                new Book(6, "Java Book 2", Category.PROGRAMMING, 4.6),
                new Book(7, "History Book 2", Category.HISTORY, 4.1),
                new Book(8, "Science Book 2", Category.SCIENCE, 4.4),
                new Book(9, "Novel 2", Category.FICTION, 4.9),
                new Book(10, "Math Book 2", Category.PROGRAMMING, 4.3),
                new Book(5, "Math Book 1", Category.PROGRAMMING, 4.7),
                new Book(6, "Java Book 2", Category.PROGRAMMING, 4.6)
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

        // first identity, then accumulator sb + string, then a combiner sb + sb
        StringBuilder sum2 = Arrays.stream(bookRates).reduce(new StringBuilder(), (sb1, s) -> sb1.append(s)
                , (sb2, sb3) -> sb2.append(sb3));
        System.out.println(sum);
        System.out.println(sum2.toString());
    }
}
