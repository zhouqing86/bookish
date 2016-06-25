package app.controller;


import app.model.Book;
import app.service.BookService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookDatabaseServiceImpl;

    @RequestMapping(value = {"/books", "/"})
    public String index(@RequestParam(value = "page",defaultValue = "1") Integer page,
                        @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                        Map<String, Object> model) {
        model.put("hello", "ThoughtWorks");
        Pageable pageable = new PageRequest(page-1,pageSize);
        model.put("books", bookDatabaseServiceImpl.findByPagination(pageable));
        return "books";
    }

    @RequestMapping("/book/{asin}")
    public String book(@PathVariable("asin") String asin, Map<String, Object> model) {
        Book book = bookDatabaseServiceImpl.getBook(asin);
        model.put("book", book);
        return "bookDetail";
    }

    @RequestMapping("/trigger")
    public String trigger(Map<String, Object> model) {
        Gson gson = new GsonBuilder().create();
        List<Book> books = gson.fromJson(getFile("books.json"), new TypeToken<List<Book>>(){}.getType());
        bookDatabaseServiceImpl.save(books);
        return "ok";
    }


    private String getFile(String fileName){

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }


}
