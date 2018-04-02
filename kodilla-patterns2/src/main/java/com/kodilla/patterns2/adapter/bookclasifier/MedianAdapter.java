package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.*;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {

        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books = new HashMap<>();

        Iterator<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> iterator = bookSet.iterator();
        while (iterator.hasNext()) {
            com.kodilla.patterns2.adapter.bookclasifier.librarya.Book setElement = iterator.next();
            books.put(new BookSignature(setElement.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                            setElement.getAuthor(), setElement.getAuthor(), setElement.getPublicationYear()));
        }

        return medianPublicationYear(books);
    }
}
