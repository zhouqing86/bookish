package app.service.impl;

import app.model.Book;
import app.service.BookService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

    String url = "http://localhost:9999/books.json";

    public List<Book> allBooks() {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.setRequestHeader("Content-Type","application/json; charset=utf-8");
        method.setRequestHeader("Accept","application/json; charset=utf-8");

        List<Book> books = new ArrayList<>();

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            Gson gson = new GsonBuilder().create();
            books = gson.fromJson(""+method.getResponseBodyAsString(), new TypeToken<List<Book>>(){}.getType());

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println("books.size" + books.size());
            System.out.println("books: " + books.toString());

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
        return books;
    }

    @Override
    public List<Book> getBooks() {
        return allBooks();
    }

    @Override
    public Book getBook(String asin) {
        return findBookByAsin(asin);
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void save(List<Book> books) {

    }

    private Book findBookByAsin(String asin) {
        for(Book book : allBooks()) {
            if(asin.equalsIgnoreCase(book.getAsin())) {
                return book;
            }
        }
        return null;
    }
}
