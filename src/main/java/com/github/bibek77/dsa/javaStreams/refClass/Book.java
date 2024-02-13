package com.github.bibek77.dsa.javaStreams.refClass;

import java.util.Objects;

/**
 * @author bibek
 */
public class Book {
    private String title;
    private Category category;
    private double rating;
    private double price;

    private int id;

    public Book(int id, String title, Category category, double rating, double price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.price = price;
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

    public int getId() {return id; }

    public double getPrice() {return price;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
