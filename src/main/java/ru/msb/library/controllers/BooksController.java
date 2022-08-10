package ru.msb.library.controllers;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/books")
public class BooksController {

    @GetMapping()
    public String index(Model model) {
        return null;
    }

}
