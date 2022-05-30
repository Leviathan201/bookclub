package com.bookclub.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.*;

public class TestWishlistItem {

    //@Mock
    private WishlistItem wishlist; //linking wishlistitem file

    private static String id; //Holds id string
    private static String isbn; //Holds isbn string
    private static String title; //Holds title string
    private static String username; //Holds username string


    @BeforeAll
    //New book adding to wishlist
    public static void init() {

        isbn = "000000000000";
        title = "Dune Part 2";
        username = "admin-TaborJames";
    }

    @Test
    //Creating a new wishlist item by using the username
    void testCreateNewWishlistItemWithUsername() {
        WishlistItem item = new WishlistItem(isbn, title, username);
        assertEquals(id, item.getId());
        assertEquals(isbn, item.getIsbn());
        assertEquals(title, item.getTitle());
        assertEquals(username, item.getUsername());
    }

    @Test
    //Creating a new book to add to wishlist without being logged into username
    void testCreateNewWishlistItemWithoutUsername() {
        WishlistItem item = new WishlistItem(isbn, title);
        assertEquals(id, item.getId());
        assertEquals(isbn, item.getIsbn());
        assertEquals(title, item.getTitle());
        assertNotEquals(username, item.getUsername());
    }

    @Test
    //Tostring for the new book being added to wishlist
    void testWishlistItemToString() {
        WishlistItem item = new WishlistItem(isbn, title);
        String result = String.format("WishlistItem{id=%s, isbn=%s, title=%s, username=%s", null, isbn, title, null);
        assertEquals(result, item.toString());

        WishlistItem item2 = new WishlistItem(isbn, title, username);
        result = String.format("WishlistItem{id=%s, isbn=%s, title=%s, username=%s", null, isbn, title, username);
        assertEquals(result, item2.toString());

    }
}