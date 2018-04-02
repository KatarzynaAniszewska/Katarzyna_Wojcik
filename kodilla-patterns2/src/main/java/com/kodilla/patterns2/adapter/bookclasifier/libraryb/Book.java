package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class Book {
    private final String author;
    private final String title;
    private final int yearOfpublication;

    public Book(String author, String title, int yearOfpublication) {
        this.author = author;
        this.title = title;
        this.yearOfpublication = yearOfpublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfpublication() {
        return yearOfpublication;
    }
}
