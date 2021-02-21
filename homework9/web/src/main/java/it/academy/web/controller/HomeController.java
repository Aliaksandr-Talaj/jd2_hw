package it.academy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String firstPage() {
        return "first";
    }

    @GetMapping("/hello")
    public String helloPage() {

        return "hello";
    }

    @GetMapping("/main")
    public String mainPage() {

        return "main";
    }

    @GetMapping("/exit")
    public String exitPage() {

        return "exit";
    }

}
