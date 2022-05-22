/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;

public class BookOfTheMonth {

    @Id
    private String id; //Id of the book

    private Integer month;//Id of the month

    @NotEmpty(message = "ISBN is a required field")
    private String isbn;//ISBN of the book

    //Default Constructor
    public BookOfTheMonth() {}

    //Constructor
    public BookOfTheMonth(int month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    }

    //Getters and Setters
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getMonth() {
        return month;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    //ToString method
    @Override
    public String toString() {
        return String.format("BookOfTheMonth{id=%s, month=%s, isbn=%s}", id, month, isbn);
    }
}