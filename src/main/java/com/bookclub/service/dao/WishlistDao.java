/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;
import com.bookclub.service.GenericDao;

//Extends the users interface to include wishlist
public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
}