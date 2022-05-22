/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */

package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    //Creates a new variable for the Book List
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); //Set today's date
        int calMonth = cal.get(Calendar.MONTH) + 1; //Find the current month

        RestBookDao bookDao = new RestBookDao();
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));

        StringBuilder isbnBuilder = new StringBuilder();
        isbnBuilder.append("ISBN:"); //Find the ISBN

        for (BookOfTheMonth monthlyBook : monthlyBooks) {
            isbnBuilder.append(monthlyBook.getIsbn()).append(",");
        }

        String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() - 1);

        List<Book> books = bookDao.list(isbnString);

        model.addAttribute("books", books);

        return "index"; //Return the month and date
    }


    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    //Sets parameter for the pathvariable which is the ID, which will be associated to the ISBN
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        System.out.println("********getMonthlyBook: " + id);
        String isbn = id;
        System.out.println(id);

        //Creates a new instance for the MemBookDao and calls it by finding it
        RestBookDao bookDao = new RestBookDao();
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