/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */
package com.bookclub.service;

import java.util.List;

public interface GenericDao<E,K> {
    public List<E> list(); //Return a list of objects of type E.
    public E find(K key); //Return an object of type E by type K value.
}
