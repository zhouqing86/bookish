package app.service;


import app.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(String asin);

    void save(Book book);


    void save(List<Book> books);
}
