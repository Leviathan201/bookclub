/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.model;

import java.util.List;

public class Book {
    private String isbn; // Holds ISBN code
    private String title; //Holds Books title
    private String description; // Holds description for book
    private String infoUrl; //Gets the info of where the book is
    private int numOfPages; //Holds the number of pages in the book

    //Default Constructor
    public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
    }

    //Constructor
    public Book(String isbn, String title, String infoUrl) {
        this.isbn = isbn;
        this.title = title;

    }

    //Getter and Setter methods below
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    //Returns the data being held by each string in a specific format
    @Override
    public String toString() {
        return String.format("Book{isbn=%s, title=%s, description=%s, infoUrl=%s, numOfPages=%s}", isbn, title, description, infoUrl, numOfPages);
    }

}