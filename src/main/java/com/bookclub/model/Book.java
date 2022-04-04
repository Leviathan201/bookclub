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
    private int numOfPages; //Holds the number of pages in the book
    private List<String> authors; //Creates a list of authors

    //Default Constructor
    public Book() {
        this.isbn = "";
        this.title = "";
        this.description = "";
        this.numOfPages = 0;
    }

    //Constructor
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    //Getter and Setter methods below
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfPages() {
        return this.numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    //Returns the data being held by each string in a specific format
    @Override
    public String toString() {
        String temp = "Book{isbn=<" + this.isbn + ">," +
                "title=<" + this.title + ">," +
                "description=<" + this.description +">," +
                "numOfPages=<" + this.numOfPages + ">," +
                "authors=<" + this.authors + "}";
        return temp;
    }

}