package com.divae.sk.sbsk.author;

import com.divae.sk.sbsk.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorService {

    private final BookService bookService;

    List<Author> getAuthors(){
        Author author1 = Author.builder()
                .id(1L)
                .firstName("Dan")
                .lastName("Simmons")
                .books(bookService.getBooks().stream().filter(book -> book.getId() == 1).collect(Collectors.toList()))
                .build();
        Author author2 = Author.builder()
                .id(2L)
                .firstName("Iain")
                .lastName("Banks")
                .books(bookService.getBooks().stream().filter(book -> book.getId() == 2).collect(Collectors.toList()))
                .build();
        return List.of(author1, author2);
    }
}
