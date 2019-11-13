package com.divae.sk.sbsk.book.view;

import com.divae.sk.sbsk.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BookViewController {

    private final BookService bookService;

    @GetMapping("/booksView")
    public String index(final Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "booksView";
    }
}
