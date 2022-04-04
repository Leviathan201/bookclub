/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */
package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.service.dao.BookDao;
import com.bookclub.model.Book;

//Implementing the BookDao interface
public class MemBookDao implements BookDao {

    private List<Book> books = new ArrayList<Book>(); //Private variable for the Book List


    public MemBookDao() {
        //Add five new Book objects

        List<String> authors = new ArrayList<String>();
        authors.add("Eichiro Oda");
        Book book1 = new Book("978-1492078005", "One Piece", "A story about a young man made of rubber, whom, inspired by his childhood idol, the powerful pirate Red Haired Shanks, sets off on a journey from the East Blue Sea to find the mythical treasure, the One Piece, and proclaim himself the King of the Pirates", 5102, authors);


        authors = new ArrayList<String>();
        authors.add("ONE");
        Book book2 = new Book("7-2592-2402-1", "One Punch Man", "A story about a guy who is a hero for fun and is looking for a fight that will last longer than one punch", 6100,authors);

        authors = new ArrayList<String>();
        authors.add("Christie Golden");
        Book book3 = new Book("978-1416-55088-4", "Thrall: Twilight of the Aspects ", "Thrall an orc, must purge his own doubts in order to discover his purpose in the world and aid Azeroth's dragonflights as they face the Twilight of the Aspects", 901, authors);

        authors = new ArrayList<String>();
        authors.add("Test");
        Book book4 = new Book("978-0201616224", "The Pragmatic Programmer", "The Pragmatic Programmer: From Journeyman to Master", 1024, authors);

        authors = new ArrayList<String>();
        authors.add("Yabako Sandrovich");
        Book book5 = new Book("978-0132350884", "Kengan Ashura", "Wealthy business owners and merchants hire gladiators to fight in unarmed combat where the winner takes all, called Kengan matches", 5102, authors);

        addBook(book1);
        addBook(book2);
        addBook(book3);
        addBook(book4);
        addBook(book5);
    }

    //Giving the ability to add more books
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    //Override list that will array the books
    public List<Book> list() {
        return this.books;
    }

    @Override
    //Returns the book based on the parameter values
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}