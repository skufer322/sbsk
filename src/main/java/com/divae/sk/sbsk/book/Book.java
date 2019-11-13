package com.divae.sk.sbsk.book;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class Book {

    // @formatter:off
    @NonNull private Long id;
    private String title;
    private Integer numPages;
    // @formatter:on
}
