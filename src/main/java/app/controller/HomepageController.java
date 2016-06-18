package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

@Controller
public class HomepageController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        System.out.println("indexindexindexindexindexindexindex");
        return "index";
    }
}
