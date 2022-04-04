/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;

@Controller
@RequestMapping("/")
public class HomeController {

    //Creates a new variable for the Book List
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        MemBookDao bookDao = new MemBookDao();
        List<Book> books = bookDao.list();

        //Finds all the books in the Book file
        for (Book book : books) {
            System.out.println(book.toString());
        }

        model.addAttribute("books", books); //Assigns the books to the model attribute "books"

        return "index"; //Sends book to the index.html
    }


    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    //Sets parameter for the pathvariable which is the ID, which will be associated to the ISBN
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        System.out.println("********getMonthlyBook: " + id);
        String isbn = id;
        System.out.println(id);

        //Creates a new instance for the MemBookDao and calls it by finding it
        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(isbn);


        System.out.println(book.toString());

        //Returns the book values to the view.html page
        model.addAttribute("book", book);
        return "monthly-books/view";
    }

    //About.Us information page
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    //Contact Us infromation page
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {
        return "contact";
    }

}