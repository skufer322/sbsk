package com.divae.sk.sbsk.author;

import com.divae.sk.sbsk.book.Book;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
class Author {

    // @formatter:off
    @NonNull private Long id;
    private String firstName;
    private String lastName;
    @NonNull @Builder.Default private List<Book> books  = new ArrayList<>();
    // @formatter:on
}
