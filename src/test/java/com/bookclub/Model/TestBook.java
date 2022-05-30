package com.bookclub.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class TestBook {

    //@Mock
    private Book book;
    private static String isbn; //Holds ISBN string
    private static String title; //Holds Title string
    private static String description; //Holds description string
    private static int numOfPages; //Holds number of pages string
    private static String infoUrl; //Holds info string


    @BeforeAll
    //Test to add the book information
    public static void init() {
        isbn = "0000000000";
        title = "Dune";
        description = "A story about spice";
        numOfPages = 500;
        infoUrl = "test.com";
    }


    @Test
    //Creates the new book from the test
    void testCreateNewBook() {
        Book book = new Book(isbn, title, description, infoUrl, numOfPages);
        assertEquals(isbn, book.getIsbn());
    }

    @Test
    //The tostring format for the new book
    void testBookToString() {
        Book book = new Book(isbn, title, description, infoUrl, numOfPages);
        String result = String.format("Book{isbn=%s, title=%s, description=%s, infoUrl=%s, numOfPages=%s}", isbn, title, description, infoUrl, numOfPages);
        assertEquals(result, book.toString());
    }

}
