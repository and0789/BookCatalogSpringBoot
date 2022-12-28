package com.itc.bookcatalogv2.controller;

import com.itc.bookcatalogv2.dto.BookCreateDTO;
import com.itc.bookcatalogv2.dto.BookDetailDTO;
import com.itc.bookcatalogv2.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @GetMapping("list")
    public String findBookList(Model model){
        List<BookDetailDTO> books = bookService.findBookListDetail();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("new")
    public String loadBookForm(Model model) {
        BookCreateDTO dto = new BookCreateDTO();
        model.addAttribute("bookCreateDTO", dto);
        return "book/book-new";
    }

    @PostMapping("new")
    public String addNewBoo(
            @ModelAttribute("bookCreateDTO")
            @Valid BookCreateDTO dto,
            BindingResult bindingResult,
            Errors errors,
            Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("bookCreateDTO", dto);
            return "book/book-new";
        }
        bookService.createNewBook(dto);
        return "redirect:/book/list";
    }
}
