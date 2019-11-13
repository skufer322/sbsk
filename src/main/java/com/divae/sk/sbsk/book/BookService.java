package com.divae.sk.sbsk.book;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    public List<Book> getBooks(){
        Book book1 = Book.builder()
                .id(1L)
                .title("Hyperion")
                .numPages(1600)
                .build();
        Book book2 = Book.builder()
                .id(2L)
                .title("Der Algebraist")
                .numPages(800)
                .build();
        return List.of(book1, book2);
    }
}
