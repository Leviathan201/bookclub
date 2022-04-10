/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    List<WishlistItem> wishlist; //Private property of the wishlist

    //Array based on the previous books being used
    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("978-1492078005", "One Piece"));
        this.wishlist.add(new WishlistItem("7-2592-2402-1", "One Punch Man"));
        this.wishlist.add(new WishlistItem("978-1416-55088-4", "Thrall: Twilight of the Aspects "));
        this.wishlist.add(new WishlistItem("978-0201616224", "The Pragmatic Programmer"));
        this.wishlist.add(new WishlistItem("978-0132350884", "Kengan Ashura"));
    }

    //Will return the list array
    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    //Returns item from the array based on the ISBN used by the user
    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }
}
