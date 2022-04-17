/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
//Implements the wishlistdao interface
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate; //Holds the mongoTemplate

    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity); //Finds all the lists and allows adding to the wishlist
    }

    @Override
    //Updates the wishlist
    public void update(WishlistItem entity) {

    }

    @Override
    //Allows user to remove item from the wishlist
    public boolean remove(WishlistItem entity) {
        Query query = new Query();

        query.addCriteria(Criteria.where("id").is(entity.getId()));

        mongoTemplate.remove(query, WishlistItem.class);

        return true;
    }

    @Override
    //Returns the list from the wishlist
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    //Finds the wishlist item within the wishlist
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}