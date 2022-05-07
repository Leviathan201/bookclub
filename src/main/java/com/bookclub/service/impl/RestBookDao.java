/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021
Additional Modifications by James Tabor
 */
package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class RestBookDao implements BookDao {

    public RestBookDao() {  }

    @Override
    public List<Book> list() {
        String isbnString = "ISBN:9780593099322,9780261102361,9780261102378,9780590302715,9780316769532"; //Books are listed in order based on inputted ISBN

        Object doc = getBooksDoc(isbnString);

        List<Book> books = new ArrayList<Book>(); //Creates an array for all the books request

        List<String> titles = JsonPath.read(doc, "$..title"); //Provides user with the title of the book
        List<String> isbns = JsonPath.read(doc, "$..bib_key"); //Provides user with the isbn info of the book
        List<String> infoUrls = JsonPath.read(doc, "$..info_url"); //Provides user with information about the book

        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index))); //Gives the users the ability to add a new book to the list
        }

        return books;
    }

    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key"); //Finds the book based on the ISBN
        List<String> titles = JsonPath.read(doc, "$..title"); //Finds the book based on the title
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle"); //Gives users the option of subtitles if it has it
        List<String> infoUrls = JsonPath.read(doc, "$..info_url"); //Gives users information about the book
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages"); //Details how many pages are in the book

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        Book book = new Book(isbn, title, desc, infoUrl, numOfPages);

        return book; //Returns the book information based on what is found
    }

    private Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";

        RestTemplate rest = new RestTemplate(); // call the RestTemplate object to invoke a third-party API call.

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        String jsonBooklist = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }
}