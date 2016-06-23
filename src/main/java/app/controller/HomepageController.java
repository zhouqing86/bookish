package app.controller;

import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@Controller
public class HomepageController {

    @Autowired
    private BookService bookServiceImpl;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("hello", "ThoughtWorks");
        model.put("books",bookServiceImpl.getBooks());
        return "index";
    }
}
