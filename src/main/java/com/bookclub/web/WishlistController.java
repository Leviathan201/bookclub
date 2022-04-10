/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MemWishlistDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        MemWishlistDao wishlistDao = new MemWishlistDao(); //Holds new wishlist

        List<WishlistItem> wishlist = wishlistDao.list();

        model.addAttribute("wishlist", wishlist); //Model attributes that have a key wishlist and variable wishlist

        return "wishlist/list"; //Returns you to the wishlist list
    }

    @RequestMapping(method = RequestMethod.GET, path = "/new") //Decorator for a new path
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new"; //Returns user back to wishlist
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
        System.out.println(wishlistItem.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {  //If statement added if the binding results has errors
            return "wishlist/new"; //Redirects the user back to a new wishlist
        }

        return "redirect:/wishlist"; //Return back to the wishlist
    }
}