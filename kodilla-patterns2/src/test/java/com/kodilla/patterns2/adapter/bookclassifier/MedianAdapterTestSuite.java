package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.company.SalaryAdapter;
import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.newhrsystem.SalaryProcessor;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("Sienkiewicz","Potop",1977,"a");
        Book book2 = new Book("Davies","1944",1980,"b");
        Book book3 = new Book("Nalkowska","Granica",1990,"c");
        Book book4 = new Book("Mickiewicz","Pan Tadeusz",1999,"d");
        Book book5 = new Book("Andersen","Baśnie",2000,"e");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int yearOfPublicationMediana = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(1990,yearOfPublicationMediana);
            }
        }

