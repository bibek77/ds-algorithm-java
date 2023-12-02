package com.github.bibek77.dsa.javaSnippets;

import com.github.bibek77.dsa.javaSnippets.refClass.Book;
import com.github.bibek77.dsa.javaSnippets.refClass.Category;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author bibek
 */
public class StreamsAPILibrary {

    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book("Java Book", Category.PROGRAMMING, 4.8),
                new Book("History Book", Category.HISTORY, 4.2),
                new Book("Science Book", Category.SCIENCE, 4.5),
                new Book("Novel", Category.FICTION, 4.7),
                new Book("Math Book", Category.PROGRAMMING, 4.0)
        );

        Map<Category, List<Book>> booksByCategory =
                books.stream().filter(book -> book.getRating()>=4.5)
                        .collect(groupingBy(Book::getCategory));

        System.out.println(booksByCategory);
    }
}
