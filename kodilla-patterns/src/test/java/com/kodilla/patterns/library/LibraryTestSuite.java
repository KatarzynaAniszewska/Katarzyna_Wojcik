package com.kodilla.patterns.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void TestGetBooks(){

        //Given
        Library library = new Library("Library 1");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n->library.getBooks().add(new Book("Title"+n,"Author"+n,
                        LocalDate.of(2010,10,10+n))));

        //When
        //making a shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("ClonedLibrary");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        //making a deep copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("DeepClonedLibrary");
        }catch (CloneNotSupportedException e){
            System.out.println(e);

        }

        //Then

        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        Assert.assertEquals(10, library.getBooks().size());
        Assert.assertEquals(10, clonedLibrary.getBooks().size());
        Assert.assertEquals(10, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());


    }

}
