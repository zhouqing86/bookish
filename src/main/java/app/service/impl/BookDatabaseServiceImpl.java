package app.service.impl;


import app.model.Book;
import app.model.BookDao;
import app.service.BookService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("bookDatabaseServiceImpl")
public class BookDatabaseServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    public Book getBook(String asin) {
        return bookDao.findByAsin(asin);
    }


    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void save(List<Book> books) {
        bookDao.save(books);
    }

    @Override
    public Page<Book> findByPagination(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

}
