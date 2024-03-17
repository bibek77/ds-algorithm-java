package com.github.bibek77.dsa.systemDesign.LibraryManagementSystem;

import java.util.HashMap;
import java.util.List;

/**
 * @author bibek
 * <p>
 * Actors:
 * 1. Lirarian
 * 2. Members
 * <p>
 * Use Cases:
 * 1. Add/Remove/Edit books
 * 2. Register New Account / Cancel Membership
 * 3. Checkout
 * 4. Renew
 * 5. Return
 * <p>
 * Requirements:
 * 1. Members can search for a book (using title, author or subject).
 * 2. Book will have uniqueId, Rack no where its placed.
 * 3. Book can have multiple copies and member can check out any copy.
 * 4. System can retrieve info about a particular book.
 * 5. Max limit (5) on how many books can be checked out.
 * 6. Max limit (14) on how many days a book can be kept.
 * 7. System will collect fine for book returned after due date.
 * 8. Member will have a library card with unique barcode.
 * <p>
 * Classes :
 * 1. Book - Unique Book
 * 2. BookItem - Each book can have multiple copies hence bookItem each with a unique barcode.
 * 3. Account - Can be of 2 types : Librarian and Member
 * 4. LibraryCard - Each member will be issued a library card to uniquely identify also keep track of issue/return.
 * 5. Author - Encapsulate a book author.
 * 6. Rack - Will be identified by a rack number & maybe additonal location.
 * 7. BookLending - Manage the checking out of book items.
 * 8. Fine - Calculating and collecting fines from library members.
 * <p>
 * Implementations:
 * 1. Enum & Constants
 * 2. Account, Librarian, Member, LibraryCard
 * 3. Book, BookItem, Rack
 * 4. BookLending, Fine
 * 5. Search Interface & Cataloq
 */
public class LibraryManagementSystem {
    //    1. Enum & Constants
    public enum BookStatus {
        AVAILABLE,
        LOAN,
        LOST
    }

    public enum AccountStatus {
        ACTIVE,
        CLOSED,
        BLACKLISTED

    }

    public class Constants {
        public static final int MAX_BOOKS_ISSUED_TO_USER = 5;
        public static final int MAX_DAYS_ISSUED_FOR = 14;
    }

    // Account , Librarian, Member, Library Card

    public class LibraryCard {
        private String cardNumber;
        private String barCode;
        private String issuedAt;
        private boolean isActive;

    }

    public class Account {
        private String id;
        private String username;
        private String password;
        private AccountStatus status;
        private LibraryCard libraryCard;
        // Additional method
//        public boolean resetPassword();
    }

    public class Librarian extends Account {
//        public boolean addBookItem(BookItem bookItem);
//        public boolean blockMember(Member member);
//        public boolean unblockMember(Member member);
//        public boolean cancelMembership(Member member);
    }

    public class Member extends Account {
        private String dateOfMembership;
        private int totalBooksCheckedOut;

//        public int incrementTotalBooksCheckedout();
//        public boolean checkoutBook(BookItem item);
//        public boolean returnBookItem(BootItem item);
//        public boolean renewBookItem(BootItem item);
//        public int checkForFine(String barCode);
    }

    public class Author extends Account {
        private int booksPublished;
        private List<Book> book;
    }

    // Book, BookItem, Rack

    public class Book {
        private String title;
        private String subject;
        private String publisher;
        private int numberOfPages;
        private List<Author> authors;
    }

    public class bookItem extends Book {
        private String barcode;
        private boolean isReferenceOnly; //not eligible for checkout
        private String borrowed;
        private String dueDate;
        private double price;
        private BookStatus status;
        private String dateOfPurchase;
        private String publicationDate;
        private String placedAt;
    }

    public class Rack {
        private int rackNumber;
        private String locationIdentifier;
    }

    // BookLending & Fine
    public class BookLending {
        private String creationDate;
        private String dueDate;
        private String returnDate;
        private String bookItemBarCode;
        private String memberId;

//        public static void lendBook(String barcode, String memberId);
//        public static BookLending fetchLendingDetails(String barcode);
    }

    public class Fine {
        private String creationDate;
        private String bookItemBarCode;
        private String memberId;
        private String amount;

//        public static void collectFine(String memberId, long days);
    }

    // Search Interface & Cataloging
    public interface Search {
        public List<Book> searchByTitle(String title);

        public List<Book> searchByAuthor(String author);

        public List<Book> searchBySubject(String subject);
    }

    public class Catalogue implements Search {
        private HashMap<String, List<Book>> bookTitles;
        private HashMap<String, List<Book>> bookAuthors;
        private HashMap<String, List<Book>> bookSubjects;

        public List<Book> searchByTitle(String query) {
            return bookTitles.get(query);
        }

        public List<Book> searchByAuthor(String query) {
            return bookAuthors.get(query);
        }

        public List<Book> searchBySubject(String query) {
            return bookSubjects.get(query);
        }
    }
}