package com.divae.sk.sbsk.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable final int id){
        return authorService.getAuthors().stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AuthorNotFoundException("No author with id=" + id + " exists."));
    }
}
