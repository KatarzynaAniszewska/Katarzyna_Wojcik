package com.kodilla.patterns.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype {
    String name;
    Set<Book>books=new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "Library{" + name + "}";

        for (Book book : books) {
            s = s + "\n" + book.toString();

        }
        return s;
    }

    public Library shallowCopy()throws CloneNotSupportedException{
        return  (Library) super.clone();
    }
    public Library deepCopy()throws CloneNotSupportedException{
        Library clonedLibrary = (Library) super.clone();
        clonedLibrary.books = new HashSet<>();

        for(Book book:books ){
            Book clonedBook = new Book(book.getTitle(),book.getAuthor(),book.getPublicationDate());

            clonedLibrary.getBooks().add(clonedBook);
        }
        return clonedLibrary;
    }
}
