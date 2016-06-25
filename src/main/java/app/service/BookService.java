package app.service;


import app.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(String asin);

    void save(Book book);


    void save(List<Book> books);

    Page<Book> findByPagination(Pageable pageable);
}
