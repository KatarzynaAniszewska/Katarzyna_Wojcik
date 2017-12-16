package com.kodilla.stream.immutable;

public final class Book {
    private final String title;
    private final String author;
    private final int yearOfpublication;

    public Book(final String title, final String author, final int yearOfpublication) {
        this.title = title;
        this.author = author;
        this.yearOfpublication = yearOfpublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfpublication() {
        return yearOfpublication;
    }

}
