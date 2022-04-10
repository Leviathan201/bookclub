/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WishlistItem {

    @NotNull
    @NotEmpty(message = "ISBN is a required field.") //Should tell the user to provide it with a ISBN
    private String isbn; //Holds the ISBN

    @NotNull
    @NotEmpty(message = "Title is a required field.") //Should tell the user to provide the book title
    private String title;  //Holds the Title

    //Two constructors, one default and one with the parameters
    public WishlistItem() {}

    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    //Getters and setters
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

    //Override and tostring to return the string as the below format
    @Override
    public String toString() {
        return String.format("WishlistItem{isbn=%s, title=%s}", isbn, title);
    }
}