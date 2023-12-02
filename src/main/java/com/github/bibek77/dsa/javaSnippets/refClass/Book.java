package com.github.bibek77.dsa.javaSnippets.refClass;

/**
 * @author bibek
 */
public class Book {
    private String title;
    private Category category;
    private double rating;

    public Book(String title, Category category, double rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                '}';
    }
}
