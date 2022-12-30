package com.itc.bookcatalogv2.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("book")
public class BookController {

//    private final BookService bookService;
//
//    @GetMapping("list")
//    public String findBookList(Model model){
//        List<BookDetailDTO> books = bookService.findBookListDetail();
//        model.addAttribute("books", books);
//        return "book/list";
//    }
//
//    @GetMapping("new")
//    public String loadBookForm(Model model) {
//        BookCreateRequestDTO dto = new BookCreateRequestDTO();
//        model.addAttribute("bookCreateDTO", dto);
//        return "book/book-new";
//    }
//
//    @PostMapping("new")
//    public String addNewBook(
//            @ModelAttribute("bookCreateDTO")
//            @Valid BookCreateRequestDTO dto,
//            BindingResult bindingResult,
//            Errors errors,
//            Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("bookCreateDTO", dto);
//            return "book/book-new";
//        }
//        bookService.createNewBook(dto);
//        return "redirect:/book/list";
//    }
}
